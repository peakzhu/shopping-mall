package com.panda.common.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

public class IdentifyUtils {
	
	public static String getIdentify(int uid, String loginName, String loginPass) {
		//base64(id.name.pwd.isauto.time)
		StringBuilder sb = new StringBuilder().append(uid).append(".");
		sb.append(loginName).append(".");
		sb.append(loginPass).append(".");
		sb.append(System.currentTimeMillis());
		String t = sb.toString();
		String identify = "";
		try {
			identify = Base64.encodeBase64URLSafeString(t.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return identify;
	}
	
	public static String getUid(String identify){
		if(StringUtils.isEmpty(identify)){
			return null;
		}
		try {
			String t = new String(Base64.decodeBase64(identify), "UTF-8");
			System.out.println(t);
			String[] u = t.split("\\.");
			return u[0].trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
