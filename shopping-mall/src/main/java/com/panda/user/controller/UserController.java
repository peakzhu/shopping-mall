package com.panda.user.controller;

import java.io.IOException;
import java.util.HashMap;
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
import com.panda.common.util.CommonLogicImpl;
import com.panda.common.util.JsonInterfaceTools;
import com.panda.user.business.UserBusiness;
import com.panda.user.po.UserPo;
/**
 * 主要处理个人用户相关业务
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private CacheCenter cacheCenter;
	@Resource
	private UserBusiness userBusinessImpl;
	@Resource
	private CommonLogicImpl commonLogic;
	
	private ObjectMapper mapper = new ObjectMapper();
	/**
	 * 返回个人用户注册页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/initUser.shtml")
	public String initUser(HttpServletRequest request, HttpServletResponse response){
		return "initUser";
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param loginName
	 * @param password
	 * @param isAuto
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping (value="/login.json")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response,
						@RequestParam(value="loginname", required=false)String loginName,
						@RequestParam(value="password", required=false)String password,
						@RequestParam(value="code", required=true)String code,
						@RequestParam(value="type", required=true)int type,
						@RequestParam(value="isAuto", required=false,defaultValue="2")String isAuto){
		Map<String, Object> result;
		String sessionCode =(String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if(code==null||!code.equals(sessionCode)){
				result = new HashMap<String,Object>();
				result.put("rspmsg", "验证码错误");
				result.put("code", 0);
			}else{
				result = userBusinessImpl.login(loginName, password,type).toMap();
				if(result.get("data")!=null){
					commonLogic.addCookie(request, response,(String)result.get("data"), loginName, password,isAuto);
				}
			}
			try{
					String res=mapper.writeValueAsString(result);
					return res;
			} catch (JsonGenerationException e) {
				return JsonInterfaceTools.getErrorMsg(e.getMessage());
			} catch (JsonMappingException e) {
				return JsonInterfaceTools.getErrorMsg(e.getMessage());
			} catch (IOException e) {
				return JsonInterfaceTools.getErrorMsg(e.getMessage());
			}																																
	}
	/**
	 * 返回用户管理界面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/userManager.shtml")
	@Protection
	public String userManager(HttpServletRequest request, HttpServletResponse response){
		String sid=(String)request.getAttribute("sid");
		UserPo user=cacheCenter.getUserInfo(sid);
		request.setAttribute("user", user);
		return "userManager";
	}
	/**
	 * 登出
	 * @param request
	 * @param response
	 * @return
	 * 
	 */
	//加ResponseBody不会返回对应的页面会返回字符串到页面
	@RequestMapping(value="/lgout.shtml")
	@ResponseBody
	public String lgout(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("meg","退出登录成功");
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
	//个人用户新增
	//@ModelAttribute 该注解会将 本次请求中与UserPo 对象属性一致的name 对应的值注入到 userPo的属性中  
	@RequestMapping(value="/saveUser.shtml")
	public String saveUser(HttpServletRequest request, HttpServletResponse response,
							@ModelAttribute UserPo userPo){
		userPo.setStatus(1);
		userPo.setNickName("myPandas");
		userPo.setSex("1");
		Map<String, Object> map=userBusinessImpl.saveUser(userPo).toMap();
		request.setAttribute("msg", map.get("msg"));
		return "userShow";
	}
	//个人用户更新
	//@ModelAttribute 该注解会将 本次请求中与UserPo 对象属性一致的name 对应的值注入到 userPo的属性中  
	@RequestMapping(value="/updateUser.shtml")
	public String updateUser(HttpServletRequest request, HttpServletResponse response,
							@ModelAttribute UserPo userPo){
		String sid=(String)request.getAttribute("sid");
		userPo.setIdentify(sid);
		Map<String, Object> map=userBusinessImpl.updateUser(userPo).toMap();
		request.setAttribute("msg", map.get("msg"));
		return "userShow";
	}
	/**
	 *校验个人用户登录名是否重复
	 */
	@RequestMapping(value="/checkLoginName.json")
	@ResponseBody
	public String checkLoginName(HttpServletRequest request, HttpServletResponse response,
						@RequestParam(value="loginName", required=false)String loginName){
		Map<String, Object> map=userBusinessImpl.checkLoginName(loginName).toMap();
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
	/**
	 * 分页查询用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getUserPage.json")
	@ResponseBody
	public String getUserPage(HttpServletRequest request, HttpServletResponse response,
						@RequestParam(value="loginName", required=false)String loginName,
						@RequestParam(value="nickName", required=false)String nickName,
						@RequestParam(value="pageSize", required=true)int pageSize,
						@RequestParam(value="curPage", required=true)int curPage){
		Map<String, Object> map=userBusinessImpl.getUserPage(loginName,nickName,curPage,pageSize).toMap();
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
