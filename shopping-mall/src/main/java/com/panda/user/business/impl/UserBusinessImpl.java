package com.panda.user.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.panda.common.exception.PDServiceException;
import com.panda.common.util.OperationType;
import com.panda.common.vo.Page;
import com.panda.common.vo.ReturnData;
import com.panda.user.business.UserBusiness;
import com.panda.user.po.UserPo;
import com.panda.user.service.UserService;
@Component
public class UserBusinessImpl implements UserBusiness{
	@Resource
	private UserService userServiceImpl;


	@Override
	public ReturnData<String> login(String loginName, String password, int type) {
		ReturnData<String> res=new ReturnData<String>(OperationType.LOGIN);
		try {
			String  sid=userServiceImpl.login(loginName,password,type);
			res.getSuccessResponse("用户登录成功!", sid);
		} catch (PDServiceException e) {
			res.getFailResponse(e.getErrorKey(), e.getMessage());
		}
		return res;
	}
	@Override
	public ReturnData<UserPo> getUserById(int id) {
		ReturnData<UserPo> res=new ReturnData<UserPo>(OperationType.GET_USER_BY_ID);
			try {
				UserPo  user=userServiceImpl.getUserById(id);
				res.getSuccessResponse("查询用户操作成功!", user);
			} catch (PDServiceException e) {
				res.getFailResponse(e.getErrorKey(), e.getMessage());
			}
		return res;
	}

	@Override
	public ReturnData<Integer> saveUser(UserPo userPo) {
		ReturnData<Integer> res=new ReturnData<Integer>(OperationType.SAVE_USER);
			try {
				int  code=userServiceImpl.saveUser(userPo);
				res.getSuccessResponse("保存用户操作成功!", code);
			} catch (PDServiceException e) {
				res.getFailResponse(e.getErrorKey(), e.getMessage());
			}
		return res;
	}
	
	@Override
	public ReturnData<Page<List<UserPo>>> getUserPage(String loginName,
			String nickName, int curPage, int pageSize) {
		ReturnData<Page<List<UserPo>>> res=new ReturnData<Page<List<UserPo>>>(OperationType.GET_USER_PAGE);
			try {
				Page<List<UserPo>>  page=userServiceImpl.getUserPage(loginName,nickName,curPage,pageSize);
				res.getSuccessResponse("分页查询用户操作成功!", page);
			} catch (PDServiceException e) {
				res.getFailResponse(e.getErrorKey(), e.getMessage());
			}
		return res;
	}
	@Override
	public ReturnData<Boolean> checkLoginName(String loginName) {
		ReturnData<Boolean> res=new ReturnData<Boolean>(OperationType.CHECK_LOGIN_NAME);
		try {
			boolean  code=userServiceImpl.checkLoginName(loginName);
			res.getSuccessResponse("校验用户名是否重复成功!", code);
		} catch (PDServiceException e) {
			res.getFailResponse(e.getErrorKey(), e.getMessage());
		}
		return res;
	}
	@Override
	public ReturnData<Integer> updateUser(UserPo userPo) {
		ReturnData<Integer> res=new ReturnData<Integer>(OperationType.UPDATE_USER);
		try {
			int  code=userServiceImpl.updateUser(userPo);
			res.getSuccessResponse("更新用户操作成功!", code);
		} catch (PDServiceException e) {
			res.getFailResponse(e.getErrorKey(), e.getMessage());
		}
	return res;
	}
}
