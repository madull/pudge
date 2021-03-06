package com.pudge.service.bike;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pudge.dao.bike.BikeAreaMapper;
import com.pudge.entity.bike.BikeArea;
import com.pudge.util.UUID;

@Service
public class BikeAreaThread{
	
	@Autowired
	private BikeAreaMapper bikeAreaMapper;
	
	static ThreadLocal<HashMap<String,String>> map0 = new ThreadLocal<HashMap<String,String>>(){ 
		
        @Override 
        protected HashMap<String,String> initialValue() { 
            System.out.println(Thread.currentThread().getName()+"initialValue"); 
            return new HashMap<String,String>(); 
        } 
    }; 

	public void getBikeAreas(Map<String, String> paramMap) {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
