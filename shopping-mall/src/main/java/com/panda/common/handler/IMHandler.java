package com.panda.common.handler;

import java.lang.reflect.Method;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.panda.common.Annotation.Protection;
import com.panda.common.cache.CacheCenter;
import com.panda.common.util.Constants;
import com.panda.common.util.JsonInterfaceTools;
import com.panda.common.vo.ResponseCode;
import com.panda.user.business.UserBusiness;
import com.panda.user.po.UserPo;
public class IMHandler extends HandlerInterceptorAdapter{

	private static Logger logger = LoggerFactory.getLogger(IMHandler.class);

	@Resource
	private CacheCenter cacheCenter;
	@Resource
	private UserBusiness userBusinessImpl;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String reqURI = request.getRequestURI();
		if(reqURI.startsWith("/nologin") ||reqURI.equals("/")){
			return true;
		}

		// 判断是否为静态资源的请求
		if (!StringUtils.isEmpty(reqURI) && reqURI.startsWith("/pandas/static")) {
			response.setHeader("Cache-Control", "max-age=604800"); // 对静态文件设置缓存一周
			response.setHeader("Age", "604800");
			return super.preHandle(request, response, handler);
		}
		String sid = null;
		String userInfo = null;
		Cookie[] cookies = request.getCookies();
		Cookie cookie;
		if (cookies == null) {
			logger.error("cookies is null");
		}
		for (int j = 0; cookies != null && j < cookies.length; j++) {
			cookie = cookies[j];
			if (Constants.COOKIE_NAME_SID.equals(cookie.getName())) {
				sid = cookie.getValue();
				break;
			}else if(Constants.COOKIE_NAME_UINFO.equals(cookie.getName())){
				userInfo = cookie.getValue();
			}
		}
		request.setAttribute(Constants.SID, sid);
		// TODO 置入终端类型 默认 www
    	int terminal = 1;
    	String t = request.getHeader(Constants.TERMINAL);
    	if(StringUtils.isEmpty(t)){
    		t = request.getParameter(Constants.TERMINAL);
    	}
    	try{
    		if(StringUtils.isNotEmpty(t)){
        		terminal = Integer.parseInt(t);
        	}
    	}catch (Exception e) {
			terminal = 1;
		}
    	request.setAttribute(Constants.TERMINAL, terminal);
    	
    	//置入UID
    	request.setAttribute(Constants.UID, 0);
    	
    	// 取得所有声明的方法
		Method[] methods = handler.getClass().getDeclaredMethods();
		Method method;
		boolean isLogin;
		Protection pt;
		Map<String,Object> result = null;
		UserPo user = null;
		
		for (int i = 0; methods != null && i < methods.length; i++) {
			method = methods[i];
			pt = AnnotationUtils.findAnnotation(method, Protection.class);// 取得保护的匿名注解
			if (pt != null && isProtectedReq(request, handler, method)) {
				// 受保护的方法
				isLogin = false;
				// 置入 用户uid 和用户companyId
				if (StringUtils.isNotEmpty(sid)) {
					user = cacheCenter.getUserInfo(sid);
					if (user != null) {
						request.setAttribute(Constants.UID, user.getId());
						isLogin = true;
					}
				}else if(StringUtils.isNotEmpty(userInfo)){
					String pp = new String(Base64.decodeBase64(userInfo));
					String[] psp = pp.split(":");
					if(psp != null && psp.length>=3){
						String loginName = new String(Base64.decodeBase64(psp[0]));
						String password = new String(Base64.decodeBase64(psp[1]));
						String isAuto = new String(Base64.decodeBase64(psp[2]));
						if(Constants.ISAUTO_LOGIN.equals(isAuto)){
							result = userBusinessImpl.login(loginName, password,1).toMap();
							if(result.get("data")!=null){
								request.setAttribute(Constants.SID,(String)result.get("data"));
								isLogin = true;
							}else{
								result = userBusinessImpl.login(loginName, password,2).toMap();
								if(result.get("data")!=null){
									request.setAttribute(Constants.SID,(String)result.get("data"));
									isLogin = true;
								}
							}
						}
					}
				}
				if (!isLogin) {
					// 没有登录去登录页  如果request中包含respType 并且等于"json" 则返回code=999999 表示用户未登录
					logger.info("验票失败");
					if (reqURI.endsWith(".json")) {
						response.getWriter().write(JsonInterfaceTools.getErrorMsg("用户未登录", ResponseCode.SID));
						return false;
					}
					response.sendRedirect(Constants.LOGIN_PAGE);
					return false;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	private boolean isProtectedReq(HttpServletRequest request, Object handler,
			Method method) {
		boolean rt = false;
		String[] rmClsValueString = null;
		String[] rmMtdValueString = null;
		// 取得类的映射路径
		RequestMapping rmCls = AnnotationUtils.findAnnotation(
				handler.getClass(), RequestMapping.class);
		if (rmCls != null) {
			rmClsValueString = rmCls.value();
		}
		// 取得方法的映射路径
		RequestMapping rmMtd = AnnotationUtils.findAnnotation(method,
				RequestMapping.class);
		if (rmMtd != null) {
			rmMtdValueString = rmMtd.value();
		}

		String reqURI = request.getRequestURI();
		if (rmCls == null || rmClsValueString == null) {
			// 如果类名上没有路径注解，默认置空
			rmClsValueString = new String[] { "" };
		}
		if (rmMtd == null || rmMtdValueString == null) {
			// 如果方法名上也没有路径注解，默认用方法名
			rmMtdValueString = new String[] { "/" + method.getName() };
		}
		StringBuilder uurl;
		String rexpurl;
		for (int i = 0; i < rmClsValueString.length; i++) {
			for (int j = 0; j < rmMtdValueString.length; j++) {
				uurl=new StringBuilder("/pandas");
				uurl.append(rmClsValueString[i]);
				uurl.append(rmMtdValueString[i]);
				rexpurl = uurl.toString().replaceAll("\\{.+?\\}", ".+?");
				if (reqURI.matches(rexpurl)) {
					// 请求路径匹配
					rt = true;
					break;
				}
			}
		}
		return rt;
	}
	
}
