package com.panda.user.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panda.common.Annotation.Protection;
import com.panda.common.cache.CacheCenter;
import com.panda.common.util.JsonInterfaceTools;
import com.panda.user.business.CompanyUserBusiness;
import com.panda.user.po.CompanyUserPo;
/**
 * 主要处理企业用户相关业务
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/companyUser")
public class CompanyUserController {
	@Resource
	private CacheCenter cacheCenter;
	@Resource
	private CompanyUserBusiness companyUserBusinessImpl;
	
	private ObjectMapper mapper = new ObjectMapper();
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
	 * 返回企业用户管理界面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/companyUserManager.shtml")
	@Protection
	public String companyUserManager(HttpServletRequest request, HttpServletResponse response){
		String sid=(String)request.getAttribute("sid");
		CompanyUserPo user=cacheCenter.getCompanyUserPoInfo(sid);
		request.setAttribute("user", user);
		return "companyUserManager";
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
		//保存企业用户对象
		companyUserPo.setStatus(1);
		companyUserPo.setCompanyData("该用户很有意思哦!");
		Map<String, Object> map=companyUserBusinessImpl.saveCompanyUser(companyUserPo).toMap();
		request.setAttribute("msg", map.get("msg"));
		return "userShow";
	}
	/**
	 *校验企业用户登录名是否重复
	 */
	@RequestMapping(value="/checkUserName.json")
	@ResponseBody
	public String checkUserName(HttpServletRequest request, HttpServletResponse response,
						@RequestParam(value="userName", required=false)String userName){
		Map<String, Object> map=companyUserBusinessImpl.checkUserName(userName).toMap();
		try {
			String res=mapper.writeValueAsString(map);
			return res;
		} catch (JsonGenerationException e) {
			return JsonInterfaceTools.getErrorMsg(e.getMessage());
		} catch (JsonMappingException e) {
			return JsonInterfaceTools.getErrorMsg(e.getMessage());
		} catch (IOException e) {
			return JsonInterfaceTools.getErrorMsg(e.getMessage());
		}
	}
}
