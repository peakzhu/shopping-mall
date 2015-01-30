package com.panda.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 处理系统公共业务
 * @author Administrator
 *
 */
@Controller
public class SystemController {
	/**
	 * 返回登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/login.shtml")
	public String login(HttpServletRequest request, HttpServletResponse response){
		return "login";
	}
	/**
	 * 返回top页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getTop.shtml")
	public String getTop(HttpServletRequest request, HttpServletResponse response){
		return "top";
	}
	/**
	 * 返回bottom页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getBottom.shtml")
	public String getBottom(HttpServletRequest request, HttpServletResponse response){
		return "bottom";
	}
	/**
	 * 返回userLeft页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getUserLeft.shtml")
	public String getUserLeft(HttpServletRequest request, HttpServletResponse response){
		return "userLeft";
	}
	/**
	 * 返回companyUserLeft页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getCompanyUserLeft.shtml")
	public String getCompanyUserLeft(HttpServletRequest request, HttpServletResponse response){
		return "companyUserLeft";
	}
	/**
	 * 返回个人用户主页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getUserIndex.shtml")
	public String getUserIndex(HttpServletRequest request, HttpServletResponse response){
		return "userIndex";
	}
	/**
	 * 返回企业用户主页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getCompanyUserIndex.shtml")
	public String getCompanyUserIndex(HttpServletRequest request, HttpServletResponse response){
		return "companyUserIndex";
	}
	/**
	 * 返回main页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getMain.shtml")
	public String getMain(HttpServletRequest request, HttpServletResponse response){
		return "main";
	}
	
}
