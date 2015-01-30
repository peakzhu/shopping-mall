package com.panda.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CommonLogicImpl {

	public void addCookie(HttpServletRequest request, HttpServletResponse response, String sid,String loginName, String password, String isAuto){
		Cookie cookie = new Cookie(Constants.COOKIE_NAME_SID, sid);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 30);
		cookie.setVersion(0); 
		response.addCookie(cookie);
		if(Constants.ISAUTO_LOGIN.equals(isAuto)){
			this.addUinfoCookie(request, response, loginName, password, isAuto);
		}else{
			this.clearCookie(request, response, false, true);
		}
	}
	
	private void addUinfoCookie(HttpServletRequest request, HttpServletResponse response, String loginName, 
			String password, String isAuto){
		String nameB4 = Base64.encodeBase64URLSafeString(loginName.getBytes());
		String pwdB4 = Base64.encodeBase64URLSafeString(password.getBytes());
		String isAutoB4 = Base64.encodeBase64URLSafeString(isAuto.getBytes());
		String uinfo = nameB4 + ":" + pwdB4 + ":" + isAutoB4;
		uinfo = Base64.encodeBase64URLSafeString(uinfo.getBytes());
		Cookie uinfoCookie = new Cookie(Constants.COOKIE_NAME_UINFO, uinfo);
		uinfoCookie.setPath("/");
		uinfoCookie.setMaxAge(60 * 60 * 24 * 30);
		uinfoCookie.setVersion(0); 
		response.addCookie(uinfoCookie);
	}
	
	public void clearCookie(HttpServletRequest request, HttpServletResponse response, boolean cleanSid, boolean cleanUinfo){
		String serverName = Constants.COOKIE_NAME_DOMAIN;
		if(cleanSid){
			Cookie ckSid = new Cookie(Constants.COOKIE_NAME_SID, null);
			ckSid.setPath("/");
			ckSid.setMaxAge(0);
			ckSid.setVersion(0);
			response.addCookie(ckSid);
		}
		if(cleanUinfo){
			Cookie uinfoCookie = new Cookie(Constants.COOKIE_NAME_UINFO, null);
			uinfoCookie.setPath("/");
			uinfoCookie.setMaxAge(0);
			uinfoCookie.setVersion(0);
			response.addCookie(uinfoCookie);
		}
	}
	
	private String getDomainStr(HttpServletRequest request){
		String serverName = null;
		if(StringUtils.isEmpty(serverName)){
			try{
				serverName = request.getServerName().trim();
				serverName = serverName.substring(serverName.indexOf("."), serverName.length());
				return serverName;
			}catch(Exception e){
				return serverName;
			}
		}
		return serverName;
	}
}
