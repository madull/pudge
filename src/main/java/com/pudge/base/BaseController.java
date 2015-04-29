package com.pudge.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected PrintWriter out;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	protected Map<String, Object> EVSM = new HashMap<String, Object>();
	
	@ModelAttribute
	protected void init(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		logger.info("load controller - "+System.currentTimeMillis());
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
		String webRoot=request.getContextPath();
		EVSM.put("webRoot", webRoot);
		//权限判断
		model.addAttribute("EVSM",EVSM);
	}
	
	/*@ExceptionHandler
    public String exp(HttpServletRequest request, Exception ex) {
        String resultViewName = "errors/error";

        // 记录日志
        logger.error(ex.getMessage(), ex);

        // 根据不同错误转向不同页面
        if (ex instanceof Exception) {
            resultViewName = "errors/biz-error";
        } else {
            // 异常转换
            ex = new Exception("系统太累了，需要休息!");
        }
        request.setAttribute("ex", ex);
        return resultViewName;
    }*/
	
	/*protected void outJson(Object obj){
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(writer, obj);
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			out.print(writer.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}*/
	
	/**
	 * 获取session中的sessionInfo 包括用户信息,角色,资源信息
	 * @return
	 *//*
	protected SessionInfo getSysSessionInfo(){
		
		return  (SessionInfo)session.getAttribute("sessionInfo");
		
	}*/
	
	/**
	 * 重定向到错误提示页
	 *
	 * @param exceptionCode 异常代码, 在com.zjedusoft.common.exception.WebException中定义
	 * @param request
	 * @param response
	 */
	protected void redirectToErrorPage(String exceptionCode,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("error.do?code=" + exceptionCode).forward(request, response);
	}
	

}
