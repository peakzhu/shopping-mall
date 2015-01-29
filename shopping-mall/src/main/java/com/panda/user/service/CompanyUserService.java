package com.panda.user.service;

import com.panda.common.exception.PDServiceException;
import com.panda.user.po.CompanyUserPo;

public interface CompanyUserService {
	public CompanyUserPo getCompanyUserById(int id)throws PDServiceException;
	public int saveCompanyUser(CompanyUserPo companyUserPo)throws PDServiceException;
}
