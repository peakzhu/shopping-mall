package com.panda.user.dao;

import com.panda.user.po.CompanyUserPo;

public interface CompanyUserMapper {
	public CompanyUserPo getCompanyUserById(int id);
	public int saveCompanyUser(CompanyUserPo conpanyUserPo);
	public CompanyUserPo getUserByUserName(String userName);
}
