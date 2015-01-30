package com.panda.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局常量。 包含两部分，一部分从配置文件中读取（可配置部分），一部分写死在这个常量类里面（不可配置部分）
 * 
 */
@Configuration
public class Constants {
	
	public static String SID = "sid";
	public static String UID = "uid";
	public static String TERMINAL = "terminal";
	public static String CHANNEL = "channel";
	public static String PLATCHANNEL = "platchannel";
	public static String APPVERSION = "appversion";
	public static String COOKIE_NAME_SID = "GSTDCID";
	public static String COOKIE_NAME_UINFO = "GSTDUINFO";
	public static String COOKIE_NAME_DOMAIN = "";
	public static String UNREACHED_BUSSINESS = "获取后台数据失败，请联系系统管理员";
	public static String LOGIN_PAGE = "/pandas/login.shtml";
	public static String ISAUTO_LOGIN = "2";
	
	
	
	public static String DOWNLOAD;
	public static String BILLCODE;
	
	@Value("${billCode}")
	private String billCode;
	
	@Bean
	public Constants init(){
		Constants constants = new Constants();	
		BILLCODE=billCode;
		return constants;
	}
}
