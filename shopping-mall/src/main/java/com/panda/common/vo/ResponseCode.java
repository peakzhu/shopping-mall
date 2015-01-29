package com.panda.common.vo;

import java.io.Serializable;

/**
 * 返回码定义
 * 
 */
public class ResponseCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5877785743492180268L;

	/**
	 * 默认的失败操作状态码
	 */
	final public static int FAIL = 0;

	/**
	 * 默认的成功操作状态码
	 */
	final public static int OK = 1;

	/**
	 * sid or uid 为空或失效
	 */
	final public static int SID = 1000;
	/**
	 * 参数错误
	 */
	final public static int PARAM = 2000;

	/**
	 * json参数解析错误
	 */
	final public static int PARAM_JSON = 2001;

	/**
	 * 业务层错误
	 */
	final public static int BUSINESS = 3000;

	final public static int SERVICE = 4000;

	/**
	 * 无权限
	 */
	final public static int SERVICE_NOT_LIMIT = 4005;

	/**
	 * 数据库层错误
	 */
	final public static int DAO = 5000;

	/**
	 * 配置文件错误 加载失败或参数有误
	 */
	final public static int CONFIG_ERROR = 7000;
	
	/**
	 * PD业务参数
	 */
	public static final int PD_SERVICE_ERROR = 8001;//PD业务
}
