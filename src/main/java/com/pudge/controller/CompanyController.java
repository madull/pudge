package com.pudge.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pudge.entity.Company;
import com.pudge.service.ICompany;
import com.pudge.util.CommonUtils;
@Controller
@RequestMapping("/company")
public class CompanyController  {
	private static Log log = LogFactory.getLog(CompanyController.class.getName());
	private static Logger logger = Logger.getLogger(CompanyController.class);
	@Autowired
	private  ICompany companyService;
	public void insert(){
		//User p=new User("cuiran",27);
		//dataManager.insert(p);
		 log.debug("��ӳɹ�");
	}
	
	/**
	 *<b>function:</b>��ѯ����
	 */
	@RequestMapping("/companys")  
	public ModelAndView  companys(){
		List<Company> list=companyService.findCompanys();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/companys");
		mav.addObject("users", list);
		return  mav;
	}
	
	@RequestMapping("/toUpdateCompany")  
	public ModelAndView toUpdateCompany(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/company_update");
		mav.addObject("company", companyService.findCompany(id));
		return  mav;
	}
	
	@RequestMapping("/updateCompany")  
	public String  updateCompany(@ModelAttribute Company company){
		try{
		company.setUpdateTime(new Date());
		companyService.updateCompany(company);
		}catch(Exception e){
			log.error(e);
		}
		return companyList();
	}
	
	@RequestMapping("/toAddCompany")  
	public ModelAndView toAddCompany(){
		return  returnUrl("/company_add");
	}
	
	@RequestMapping("/addCompany") 
	@ResponseBody
	public String addCompany(@ModelAttribute Company company){
		company.setCompanyName("卧槽");
		company.setCreateTime(new Date());
		company.setUpdateTime(new Date());
		companyService.addCompany(company);
		logger.info("hello log4j+mongodb");
		return "1";
	}
	
	
	public ModelAndView returnUrl(String url){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping("/delCompany") 
	public String delCompany(@RequestParam("id") String id){
		companyService.delCompany(id);
		return companyList();
	}
	
	public String companyList(){
		return "redirect:/company/companys.action";
	}
	
	@RequestMapping("/checkCompany") 
	public String checkCompany(HttpServletResponse response,HttpServletRequest request){
		try{
		    String ip=CommonUtils.getIpAddr(request);
		    Company company=companyService.searchCompanyByUrl(ip);
		    response.getWriter().print(company==null?"0":"1");
		}catch(Exception e){
			log.error(e);
		}
		return null;
	}

}
