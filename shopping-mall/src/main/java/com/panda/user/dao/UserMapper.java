package com.panda.user.dao;

import java.util.List;
import java.util.Map;

import com.panda.user.po.UserPo;

public interface UserMapper{
	public UserPo getUserById(int id);
	public int saveUser(UserPo userPo);
	public int getUserAll(Map<String,String> map);
	public List<UserPo> getUserPage(Map<String,String> map);
	public UserPo getUserByLoginName(String loginName);
}
