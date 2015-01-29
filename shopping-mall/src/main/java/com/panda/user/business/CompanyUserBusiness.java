package com.panda.user.business;

import com.panda.common.vo.ReturnData;
import com.panda.user.po.CompanyUserPo;

public interface CompanyUserBusiness {
	public ReturnData<CompanyUserPo> getCompanyUserById(int id);
	public ReturnData<Integer> saveCompanyUser(CompanyUserPo companyUserPo);
}
