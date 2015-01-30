package com.panda.user.business.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.panda.common.exception.PDServiceException;
import com.panda.common.util.OperationType;
import com.panda.common.vo.ReturnData;
import com.panda.user.business.CompanyUserBusiness;
import com.panda.user.po.CompanyUserPo;
import com.panda.user.service.CompanyUserService;
@Component
public class CompanyUserBusinessImpl implements CompanyUserBusiness{
	@Resource
	private CompanyUserService companyUserServiceImpl;

	@Override
	public ReturnData<CompanyUserPo> getCompanyUserById(int id) {
		ReturnData<CompanyUserPo> res=new ReturnData<CompanyUserPo>(OperationType.GET_COMPANY_USER_BY_ID);
		try {
			CompanyUserPo  user=companyUserServiceImpl.getCompanyUserById(id);
			res.getSuccessResponse("查询企业用户操作成功!", user);
		} catch (PDServiceException e) {
			res.getFailResponse(e.getErrorKey(), e.getMessage());
		}
	return res;
	}

	@Override
	public ReturnData<Integer> saveCompanyUser(CompanyUserPo companyUserPo) {
		ReturnData<Integer> res=new ReturnData<Integer>(OperationType.SAVE_USER);
		try {
			int  code=companyUserServiceImpl.saveCompanyUser(companyUserPo);
			res.getSuccessResponse("保存企业用户操作成功!", code);
		} catch (PDServiceException e) {
			res.getFailResponse(e.getErrorKey(), e.getMessage());
		}
	return res;
	}

	@Override
	public ReturnData<Boolean> checkUserName(String userName) {
		ReturnData<Boolean> res=new ReturnData<Boolean>(OperationType.CHECK_USER_NAME);
		try {
			boolean  code=companyUserServiceImpl.checkLoginName(userName);
			res.getSuccessResponse("校验用户名是否重复成功!", code);
		} catch (PDServiceException e) {
			res.getFailResponse(e.getErrorKey(), e.getMessage());
		}
		return res;
	}
}
