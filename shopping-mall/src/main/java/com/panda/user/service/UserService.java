package com.panda.user.service;

import java.util.List;

import com.panda.common.exception.PDServiceException;
import com.panda.common.vo.Page;
import com.panda.user.po.UserPo;

public interface UserService {
	public UserPo getUserById(int id)throws PDServiceException;
	public int saveUser(UserPo userPo)throws PDServiceException;
	public Page<List<UserPo>> getUserPage(String loginName, String nickName,
			int curPage, int pageSize)throws PDServiceException;
	public String login(String loginName, String password, int type)throws PDServiceException; 
}
