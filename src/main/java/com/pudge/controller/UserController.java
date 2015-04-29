package com.pudge.controller;

import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sourceforge.wurfl.core.Device;
import net.sourceforge.wurfl.core.WURFLEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pudge.entity.ClassDemo;
import com.pudge.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {

	@Autowired
	private UserServiceI userService;
	@Autowired
	private HttpSession session;
	
	@Autowired
	private  WURFLEngine wURFLEngine;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destination; 
	
	
	


	@RequestMapping("/login1")
	@ResponseBody
	public Object login(HttpServletRequest request,HttpServletResponse response) {
		List<ClassDemo> all = userService.getAll();
		userService.insertClass();
		System.out.println(all.toString());
		return all;
	}
	
	@RequestMapping("/login2")
	@ResponseBody
	public Object login2(HttpServletRequest request,HttpServletResponse response) {
		List<ClassDemo> all = userService.getAll();
		userService.insertClass();
		System.out.println(all.toString());
		return all;
	}
	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView  index(HttpServletRequest request,HttpServletResponse response) {
		Device device = wURFLEngine.getDeviceForRequest(request);
		System.out.println("Device: " + device.getId());
		System.out.println("Capability: " + device.getCapability("preferred_markup"));
		System.out.println("Capability: " + device.getCapabilityAsBool("is_tablet"));
		System.out.println("Capability: " + device.getCapability("device_os"));
		List<ClassDemo> all = userService.getAll();
		System.out.println(all.toString());
		return new ModelAndView("index", "users", all);
	}
	
	/**
	 * return new String("你好".getBytes(), "ISO-8859-1");  
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/send",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String  send(HttpServletRequest request,HttpServletResponse response) {
		
		final String message = "发送时间:"+System.currentTimeMillis();
		 jmsTemplate.send(  
		            destination,  
		            new MessageCreator(){  
		                public Message createMessage(Session session) throws JMSException {  
		                    return session.createTextMessage(message);  
		                }  
		            }  
		        );  
		
		return "王铜辉";
	}
	
	@RequestMapping(value="/receive",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String  receive(HttpServletRequest request,HttpServletResponse response) {
		
		 Message receive = jmsTemplate.receive(destination);
		 
		 return receive.toString();
	}

}
