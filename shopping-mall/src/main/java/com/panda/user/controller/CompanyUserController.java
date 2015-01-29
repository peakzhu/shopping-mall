package com.panda.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panda.common.cache.CacheCenter;
import com.panda.user.business.CompanyUserBusiness;
import com.panda.user.po.CompanyUserPo;

@Controller
@RequestMapping("/companyUser")
public class CompanyUserController {
	@Resource
	private CacheCenter cacheCenter;
	@Resource
	private CompanyUserBusiness companyUserBusinessImpl;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="/addProduct.shtml")
	public String addProduct(HttpServletRequest request, HttpServletResponse response){
		
		return "addProduct";
	}
	/**
	 * 返回企业用户注册页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/initCompanyUser.shtml")
	public String initCompanyUser(HttpServletRequest request, HttpServletResponse response){
		
		return "initCompanyUser";
	}
	/**
	 * 返回用户管理界面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/userManager.shtml")
	public String userManager(HttpServletRequest request, HttpServletResponse response){
		
		return "userManage";
	}
	/**
	 * 新增企业用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/saveCompanyUser.shtml")
	public String saveCompanyUser(HttpServletRequest request, HttpServletResponse response,
									@ModelAttribute CompanyUserPo companyUserPo){
		Map<String, Object> map=new HashMap<String, Object>();
		//保存企业用户对象
		map=companyUserBusinessImpl.saveCompanyUser(companyUserPo).toMap();
		request.setAttribute("msg", map.get("msg"));
		return "userShow";
	}
}
