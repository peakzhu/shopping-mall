package com.panda.user.business;

import java.util.List;

import com.panda.common.vo.Page;
import com.panda.common.vo.ReturnData;
import com.panda.user.po.UserPo;

public interface UserBusiness {
	public ReturnData<UserPo> getUserById(int id);
	public ReturnData<Integer> saveUser(UserPo userPo);
	public ReturnData<Page<List<UserPo>>> getUserPage(String loginName, String nickName,int curPage, int pageSize);
	public ReturnData<String> login(String loginName, String password, int type);
	public ReturnData<Boolean> checkLoginName(String loginName);
	public ReturnData<Integer> updateUser(UserPo userPo);
}
