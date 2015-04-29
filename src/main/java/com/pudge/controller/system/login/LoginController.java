package com.pudge.controller.system.login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pudge.base.BaseController;



/*
 * 总入口
 */
@Controller
@RequestMapping("/system")
public class LoginController extends BaseController {
	
	@RequestMapping(value="/main/index.do")
	public ModelAndView login_index(
			HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="index",required=false) String index
			){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/admin/index");
		return mv;
	}
	
	
	@RequestMapping(value="/tab.do")
	public String tab(){
		return "system/admin/tab";
	}
	
	/**
	 * 进入首页后的默认页面
	 * @return
	 */
	@RequestMapping(value="/login_default.do")
	public String defaultPage(){
		return "system/admin/default";
	}
}
