package com.panda.common.util;

/**
 * 操作类型的定义
 * 
 * @author zl
 * 
 */
public class OperationType {

	// 用户模块 100-149
	public static final int LOGIN = 100;// 用户登录
	public static final int LOGOUT = 101;// 用户登出
	public static final int SAVE_USER = 102;// 新增用户
	public static final int GET_USER_BY_ID = 103;// 根据ID查询用户
	public static final int GET_USER_PAGE=104;//分页查询用户
	// 企业用户模块 150-199
	public static final int GET_COMPANY_USER_BY_ID = 150;//根据ID查询单个企业用户
	public static final int SAVE_COMPANY_USER = 151;// 新增企业用户
}
