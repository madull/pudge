package com.pudge.service.bike;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jms.Destination;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.pudge.dao.bike.BikeAreaMapper;
import com.pudge.entity.bike.BikeArea;
import com.pudge.util.UUID;

@Service
public class BikeAreaService {

	@Autowired
	private BikeAreaMapper bikeAreaMapper;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destination;
	
	public List<BikeArea> getBikeArea(BikeArea bikeArea)throws DataAccessException {
		return bikeAreaMapper.getBikeAreaList(bikeArea);
	}
	
	public int getBikeAreaCount(BikeArea bikeArea)throws DataAccessException {
		return bikeAreaMapper.getBikeAreaCount(bikeArea);
	}
	
	private static String __EVENTVALIDATION ="";
	
	private static String __VIEWSTATE="";
	
    static ThreadLocal<HashMap<String,String>> map0 = new ThreadLocal<HashMap<String,String>>(){ 
		
        @Override 
        protected HashMap<String,String> initialValue() { 
            System.out.println(Thread.currentThread().getName()+"initialValue"); 
            return new HashMap<String,String>(); 
        } 
    }; 
	
	public boolean getBikeAreas(Map<String, String> paramMap){
		boolean success = false ;
		try {
			Document doc =Jsoup.connect("http://www.hzbus.cn/Page/BicyleNearby.aspx").data(paramMap).data("__EVENTVALIDATION", __EVENTVALIDATION).data("__VIEWSTATE", __VIEWSTATE).userAgent("Mozilla").timeout(30000).post();
			__EVENTVALIDATION = doc.select("#__EVENTVALIDATION").val();
			__VIEWSTATE = doc.select("#__VIEWSTATE").val();
			System.out.println(__EVENTVALIDATION);
			Elements select = doc.select("ul");
			for(Element element:select){
				BikeArea bikeArea=new BikeArea();
				bikeArea.setBikeAreaUid(UUID.getUUID());
				
				Elements selectlis = element.select(".bt");
				String onclickAttr = selectlis.attr("onclick");
				String click =onclickAttr.substring(onclickAttr.indexOf("(")+1,onclickAttr.indexOf(")")+1);
				String[] params = click.split(",");
				
				bikeArea.setAreaLongitude(params.length>1?params[9].replaceAll("'", ""):"");
				bikeArea.setAreaLatitude(params.length>1?params[10].replaceAll("'", ""):"");
					
				Elements selects = element.select(".bt>div");
				for(int i= 0;i<selects.size();i++){
					if(i%2==0){
						String text = selects.get(i).text().replaceAll(Jsoup.parse("&nbsp;").text(), "#").replaceAll("\\s*", "");
						bikeArea.setBikeAreaNo(text.split("#")[0]);
						bikeArea.setBikeAreaName(text.split("#")[1]);
					}else{
						String text=selects.get(i).text().replaceAll(Jsoup.parse("&nbsp;").text(), "").replaceAll("\\s{2}","#").replaceAll("\\s*", "");
						Pattern p=Pattern.compile("(\\d+)");   
						  Matcher m=p.matcher(text);       
						  if(m.find()){
							  bikeArea.setAreaRentNum(Integer.valueOf(m.group(0)));
							  bikeArea.setAreaReturnNum(Integer.valueOf(m.group(1)));
						  } 
					}
					
				}
				
				Elements selectDetails = element.select(".borderDt>table>tbody");
				for(Element elementDetail:selectDetails){
					String text = elementDetail.text().replaceAll(Jsoup.parse("&nbsp;").text(), " ");
					String[] split = text.split(" ");
							bikeArea.setServiceTime(split[0].substring(split[0].indexOf(":")+1, split[0].length()));
							bikeArea.setAreaOnDuty(split[1].contains("有人值守")?1:0);
							bikeArea.setAreaLocation(split[2].substring(split[2].indexOf(":")+1, split[2].length()));
							bikeArea.setServicePhone(split[3].substring(split[3].indexOf(":")+1, split[3].length()));
							bikeArea.setOtherService("");
							bikeArea.setRemark(split[5].substring(split[5].indexOf(":")+1, split[5].length()));
				}
				if(StringUtils.isNotEmpty(bikeArea.getBikeAreaNo())){
					bikeAreaMapper.insertBikeArea(bikeArea);
				}
				System.out.println("站点编号:"+bikeArea.getBikeAreaUid()+"站点编号："+bikeArea.getBikeAreaNo()+"站点名称:"+bikeArea.getBikeAreaName()+"可借:"+bikeArea.getAreaRentNum()+"辆 可还:"+bikeArea.getAreaReturnNum()+"辆 经度："+bikeArea.getAreaLongitude()+" 纬度："+bikeArea.getAreaLatitude()+"服务时间："+bikeArea.getServiceTime()+"服务电话："+bikeArea.getServicePhone()+"值守状况："+bikeArea.getOtherService()+"站点位置："+bikeArea.getAreaLocation());
			}
			success = true ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
		
	}
	
	/**
	 * 
	 * @param paramMap
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean getBikeAreas(Map<String, String> paramMap,Integer start,Integer end){
		for(int index = start;index<=end;index++){
		System.out.println("##站点同步##"+index+"");
		paramMap.put("__EVENTARGUMENT",String.valueOf(index));
		paramMap.put("AspNetPager1_input", String.valueOf(index-1));
			
		paramMap.put("__EVENTTARGET", "AspNetPager1");
		
		if(StringUtils.isNotEmpty(map0.get().get("__EVENTVALIDATION"))){
			paramMap.put("__EVENTVALIDATION", map0.get().get("__EVENTVALIDATION"));
		}
		if(StringUtils.isNotEmpty(map0.get().get("__VIEWSTATE"))){
			paramMap.put("__VIEWSTATE", map0.get().get("__VIEWSTATE"));
		}
		try {
			if(StringUtils.isNotEmpty(map0.get().get("__EVENTVALIDATION"))){
				paramMap.put("__EVENTVALIDATION", map0.get().get("__EVENTVALIDATION"));
			}
			if(StringUtils.isNotEmpty(map0.get().get("__VIEWSTATE"))){
				paramMap.put("__VIEWSTATE", map0.get().get("__VIEWSTATE"));
			}
			Document doc =Jsoup.connect("http://www.hzbus.cn/Page/BicyleNearby.aspx").data(paramMap).userAgent("Mozilla").timeout(30000).post();
			map0.get().put("__EVENTVALIDATION", doc.select("#__EVENTVALIDATION").val());
			map0.get().put("__VIEWSTATE", doc.select("#__VIEWSTATE").val());
			Elements select = doc.select("ul");
			for(Element element:select){
				BikeArea bikeArea=new BikeArea();
				bikeArea.setBikeAreaUid(UUID.getUUID());
				
				Elements selectlis = element.select(".bt");
				String onclickAttr = selectlis.attr("onclick");
				String click =onclickAttr.substring(onclickAttr.indexOf("(")+1,onclickAttr.indexOf(")")+1);
				String[] params = click.split(",");
				
				bikeArea.setAreaLongitude(params.length>1?params[9].replaceAll("'", ""):"");
				bikeArea.setAreaLatitude(params.length>1?params[10].replaceAll("'", ""):"");
					
				Elements selects = element.select(".bt>div");
				for(int i= 0;i<selects.size();i++){
					if(i%2==0){
						String text = selects.get(i).text().replaceAll(Jsoup.parse("&nbsp;").text(), "#").replaceAll("\\s*", "");
						bikeArea.setBikeAreaNo(text.split("#")[0]);
						bikeArea.setBikeAreaName(text.split("#")[1]);
					}else{
						String text=selects.get(i).text().replaceAll(Jsoup.parse("&nbsp;").text(), "").replaceAll("\\s{2}","#").replaceAll("\\s*", "");
						List<String> list =new ArrayList<String>();
						Pattern p=Pattern.compile("(\\d+)");   
						  Matcher m=p.matcher(text);       
							  while (m.find()){  
							      String val = m.group(); 
							      list.add(val);
							    }
							  bikeArea.setAreaReturnNum(Integer.valueOf(list.get(1)));
							  bikeArea.setAreaRentNum(Integer.valueOf(list.get(0)));
					}
				}
				
				Elements selectDetails = element.select(".borderDt>table>tbody");
				for(Element elementDetail:selectDetails){
					String text = elementDetail.text().replaceAll(Jsoup.parse("&nbsp;").text(), " ");
					String[] split = text.split(" ");
							bikeArea.setServiceTime(split[0].substring(split[0].indexOf(":")+1, split[0].length()));
							bikeArea.setAreaOnDuty(split[1].contains("有人值守")?1:0);
							bikeArea.setAreaLocation(split[2].substring(split[2].indexOf(":")+1, split[2].length()));
							bikeArea.setServicePhone(split[3].substring(split[3].indexOf(":")+1, split[3].length()));
							bikeArea.setOtherService("");
							bikeArea.setRemark(split[5].substring(split[5].indexOf(":")+1, split[5].length()));
				}
				bikeArea.setUpdateTime(new Date());
				if(StringUtils.isNotEmpty(bikeArea.getBikeAreaNo())){
					BikeArea nBikeArea = new BikeArea();
					nBikeArea.setBikeAreaNo(bikeArea.getBikeAreaNo());
					List<BikeArea> eBikeArea = bikeAreaMapper.getBikeAreaList(nBikeArea);
					if(eBikeArea!=null&&eBikeArea.size()>0){
						bikeArea.setBikeAreaUid(eBikeArea.get(0).getBikeAreaUid());
						bikeAreaMapper.updateBikeArea(bikeArea);
					}else{
						bikeAreaMapper.insertBikeArea(bikeArea);
					}
					final String message = "站点编号:"+bikeArea.getBikeAreaUid()+"站点编号："+bikeArea.getBikeAreaNo()+"站点名称:"+bikeArea.getBikeAreaName()+"可借:"+bikeArea.getAreaRentNum()+"辆 可还:"+bikeArea.getAreaReturnNum()+"辆 经度："+bikeArea.getAreaLongitude()+" 纬度："+bikeArea.getAreaLatitude()+"服务时间："+bikeArea.getServiceTime()+"服务电话："+bikeArea.getServicePhone()+"值守状况："+bikeArea.getOtherService()+"站点位置："+bikeArea.getAreaLocation();
					System.out.println(message);
				}
				/*jmsTemplate.send(  
			            destination,  
			            new MessageCreator(){  
			                public Message createMessage(Session session) throws JMSException {  
			                    return session.createTextMessage(message);  
			                }  
			            }  
			        );*/
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return false;
		
	}
	
	
	public int insertBikeArea(BikeArea bikeArea){
		return bikeAreaMapper.insertBikeArea(bikeArea);
		
	}
	
	public int updateBikeArea(BikeArea bikeArea){
		return bikeAreaMapper.updateBikeArea(bikeArea);
		
	}
	
	

}
