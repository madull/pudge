package com.pudge.controller.bike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pudge.base.BaseController;
import com.pudge.entity.bike.BikeArea;
import com.pudge.service.bike.BikeAreaLogService;
import com.pudge.service.bike.BikeAreaService;
import com.pudge.util.GeoUtil;
import com.pudge.util.PageUtil;
import com.pudge.util.UUID;

@Controller
@RequestMapping("/bikeArea_manage")
public class BikeAreaController extends BaseController{

	@Autowired
	private BikeAreaService bikeAreaService;
	
	@Autowired
	private BikeAreaLogService bikeAreaLogService;
	
	
	

	@RequestMapping("/getBikeArea")
	@ResponseBody
	public ModelAndView getBikeArea(HttpServletRequest request,BikeArea bikeArea,HttpServletResponse response) {
		/*double lng = 120.202344904651d;
		double lat = 30.2594141394393;*/
		List<BikeArea> bikeAreas = bikeAreaService.getBikeArea(bikeArea);
		/*List<BikeArea> existBikeAreas = new ArrayList<BikeArea>();
		for(BikeArea bike:bikeAreas){
			String areaLongitude = bike.getAreaLongitude();
			String areaLatitude = bike.getAreaLatitude();
			if(StringUtils.isNotEmpty(areaLongitude)&&StringUtils.isNotEmpty(areaLatitude)){
				double distanceOfMeter = GeoUtil.getDistanceOfMeter(lat, lng, Double.valueOf(areaLatitude), Double.valueOf(areaLongitude));
				if(distanceOfMeter<700){
					existBikeAreas.add(bike);
				}
			}
		}*/
		return new ModelAndView("bikeArea", "bikeAreas", bikeAreas);
	}
	
	@RequestMapping("/getBikeAreas")
	@ResponseBody
	public Object getBikeAreas(HttpServletRequest request,BikeArea bikeArea,
			@RequestParam(value="page",required=false) String page,
			HttpServletResponse response) {
		HashMap<String, String> paramMap = new HashMap<String,String>();
		paramMap.put("__EVENTTARGET", "AspNetPager1");
		paramMap.put("__EVENTARGUMENT", page);
		paramMap.put("AspNetPager1_input", String.valueOf(Integer.valueOf(page)-1));
		bikeAreaService.getBikeAreas(paramMap);
		return false;
	}
	
	
	@RequestMapping("/statBikArea.view")
	public ModelAndView statBikAreaView(HttpServletRequest request,BikeArea bikeArea,HttpServletResponse response) {
		
		return new ModelAndView("bikeAreaStat");
	}
	
	@RequestMapping("/statBikArea.do")
	@ResponseBody
	public Object statBikArea(HttpServletRequest request,BikeArea bikeArea,HttpServletResponse response) {
		
		List<String> bikeAreaNames = new ArrayList<String>();
		List<Integer> bikeRent = new ArrayList<Integer>();
		List<Integer> bikeReturn = new ArrayList<Integer>();
		List<Object> bikes = new ArrayList<Object>();
		
		List<BikeArea> bikeAreas = bikeAreaService.getBikeArea(bikeArea);
		for(BikeArea bike:bikeAreas){
			bikeAreaNames.add(bike.getBikeAreaName());
			bikeRent.add(bike.getAreaRentNum());
			bikeReturn.add(bike.getAreaReturnNum());
		}
		Map<String, Object> map = new HashMap<String, Object>();//all
		Map<String, Object> map4 = new HashMap<String, Object>();//rent
		Map<String, Object> map5 = new HashMap<String, Object>();//rent
		map4.put("name", "可借");
		map5.put("name", "可还");
		map4.put("data", bikeRent);
		map5.put("data", bikeReturn);
		
		map.put("bikeAreaNames", bikeAreaNames);
		bikes.add(map4);
		bikes.add(map5);
		
		map.put("bikes", bikes);
		
		return map;
	}
	
	
	@RequestMapping("/getBikeArea.do")
	public ModelAndView getBikeAreas(HttpServletRequest request,BikeArea bikeArea,HttpServletResponse response) {
		return new ModelAndView("/bike/bike_area");
	}
	
	@RequestMapping("/getBikeAreaLog")
	@ResponseBody
	public Object getBikeAreaLog(HttpServletRequest request,BikeArea bae,HttpServletResponse response) {
		
		bae.init();
		long begin = System.nanoTime();  
		bikeAreaService.getBikeArea(bae);
	    long end = System.nanoTime() - begin;  
	    System.out.println("count :" + end);  
	    // the second time  
	    begin = System.nanoTime();  
	    /*BikeArea bikeArea = new BikeArea();
	    bikeArea.setBikeAreaUid(UUID.getUUID());
	    bikeArea.setBikeAreaNo("22222222222");
	    	int i=bikeAreaService.insertBikeArea(bikeArea);
	    	System.out.println(i);*/
	    end = System.nanoTime() - begin;  
	    System.out.println("count :" + end);  
	    // the second time  
	    begin = System.nanoTime();  
	    bikeAreaService.getBikeArea(bae);
	    end = System.nanoTime() - begin;  
	    System.out.println("count :" + end);  
	    // the third time  
	    begin = System.nanoTime();  
	    bikeAreaService.getBikeArea(bae);
	    end = System.nanoTime() - begin;  
	    System.out.println("count :" + end);
	    //bikeAreaLogService.getBikeAreaLog(new BikeAreaLog());bikeArea
	    int bikeAreaCount = bikeAreaService.getBikeAreaCount(bae);
	    List<BikeArea> bikeArea2 = bikeAreaService.getBikeArea(bae);
	    PageUtil<BikeArea> pu =new PageUtil<BikeArea>(bae.getRows(), bikeAreaCount, bae.getPage(), bikeArea2);
	    return pu;
	}
	
	
	
	
/*	@RequestMapping("/getBikeAreaLog")
	@ResponseBody
	public ModelAndView getBikeAreaLog(HttpServletRequest request,BikeAreaExample bae,HttpServletResponse response) {
		bae.setOrderByClause("bike_area_no");
		List<BikeArea> bikeAreas = bikeAreaService.getBikeArea(bae);
		
		List<String> bikeAreaNos = new ArrayList<String>();
		List<String> bikeAreaNames = new ArrayList<String>();
		List<Integer> bikeRent = new ArrayList<Integer>();
		List<Integer> bikeReturn = new ArrayList<Integer>();
		
		for(BikeArea bikeArea:bikeAreas){
			bikeAreaNos.add(bikeArea.getBikeAreaNo());
			bikeAreaNames.add(bikeArea.getBikeAreaName());
			bikeRent.add(bikeArea.getAreaRentNum());
			bikeReturn.add(bikeArea.getAreaReturnNum());
		}
		
		BikeAreaLogWithBLOBs bikeAreaLogWithBLOBs1 = new BikeAreaLogWithBLOBs();
		bikeAreaLogWithBLOBs1.setBikeAreaLogId(UUID.getUUID());
		bikeAreaLogWithBLOBs1.setBikeAreaNos(bikeAreaNos.toString());
		bikeAreaLogWithBLOBs1.setBikeAreaNames(bikeAreaNames.toString());
		bikeAreaLogWithBLOBs1.setAreaRentNums(bikeRent.toString());
		bikeAreaLogWithBLOBs1.setAreaReturnNums(bikeReturn.toString());
		bikeAreaLogWithBLOBs1.setCreateTime(System.currentTimeMillis());
		BikeAreaLog bal= new BikeAreaLog();
		
		
		BikeAreaLogExample example=new BikeAreaLogExample();
		example.setOrderByClause("create_time");
		List<BikeAreaLog> bikeAreaLogs= bikeAreaLogService.getBikeAreaLog(example);
		
		return new ModelAndView("bikeAreaLog", "bikeAreaLogs", bikeAreaLogs);
	}*/
	
	
	@RequestMapping("/baidu_map.view")
	public ModelAndView baiduMapView(HttpServletRequest request,BikeArea bikeArea,HttpServletResponse response) {
		
		return new ModelAndView("baidumap");
	}
	
	@RequestMapping("/get_baidu_map")
	@ResponseBody
	public Object getBaiduMap(HttpServletRequest request,BikeArea bikeArea,HttpServletResponse response) {
		/*double lng = 120.202344904651d;
		double lat = 30.2594141394393;*/
		List<BikeArea> bikeAreas = bikeAreaService.getBikeArea(bikeArea);
		/*List<BikeArea> existBikeAreas = new ArrayList<BikeArea>();
		for(BikeArea bike:bikeAreas){
			String areaLongitude = bike.getAreaLongitude();
			String areaLatitude = bike.getAreaLatitude();
			if(StringUtils.isNotEmpty(areaLongitude)&&StringUtils.isNotEmpty(areaLatitude)){
				double distanceOfMeter = GeoUtil.getDistanceOfMeter(lat, lng, Double.valueOf(areaLatitude), Double.valueOf(areaLongitude));
				if(distanceOfMeter<700){
					existBikeAreas.add(bike);
				}
			}
		}*/
		return bikeAreas;
	}
	
	
	@RequestMapping("/get_baidu_map_app")
	@ResponseBody
	public Object getBaiduMapApp(HttpServletRequest request,BikeArea bikeArea,HttpServletResponse response) {
		double lat = Double.valueOf(bikeArea.getAreaLatitude());
		double lng = Double.valueOf(bikeArea.getAreaLongitude());
		
		System.out.println("经度:"+lng+"%%%%%%纬度:"+lat);
		
		List<BikeArea> bikeAreas = bikeAreaService.getBikeArea(bikeArea);
		List<BikeArea> existBikeAreas = new ArrayList<BikeArea>();
		for(BikeArea bike:bikeAreas){
			String areaLongitude = bike.getAreaLongitude();
			String areaLatitude = bike.getAreaLatitude();
			if(StringUtils.isNotEmpty(areaLongitude)&&StringUtils.isNotEmpty(areaLatitude)){
				double distanceOfMeter = GeoUtil.getDistanceOfMeter(lat, lng, Double.valueOf(areaLatitude), Double.valueOf(areaLongitude));
				if(distanceOfMeter<700){
					existBikeAreas.add(bike);
				}
			}
		}
		return existBikeAreas;
	}
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		System.out.println(list.toString());
		
	}

}
