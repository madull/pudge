package com.pudge.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pudge.base.BaseController;

@Controller
@RequestMapping("/bikeArea_restful")
public class BikeAreaRestController extends BaseController{
	
	private static final Logger logger = Logger.getLogger(BikeAreaRestController.class);

	
	
	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8" )
	@ResponseBody
	public String getBikeAreaLog(HttpServletRequest request,@PathVariable(value = "msg") String msg,HttpServletResponse response) {
	
		return "{\"msg\":\"you say:'" + msg + "'\"}";
		
	}

}
