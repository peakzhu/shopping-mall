package com.panda.user.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panda.common.exception.PDServiceException;
import com.panda.user.dao.CompanyUserMapper;
import com.panda.user.po.CompanyUserPo;
import com.panda.user.service.CompanyUserService;
@Service
public class CompanyUserServiceImpl implements CompanyUserService{
	@Autowired
	private CompanyUserMapper companyUserMapper;
	public static Logger log= LoggerFactory.getLogger("business-log");
	@Override
	@Transactional
	public CompanyUserPo getCompanyUserById(int id) throws PDServiceException {
		log.info("CompanyUserServiceImpl--getCompanyUserById 参数 id="+id);
		if(id>0){
			CompanyUserPo companyUser=companyUserMapper.getCompanyUserById(id);
			log.info("CompanyUserServiceImpl--getCompanyUserById return  companyUserPo="+companyUser.toString());
			return companyUser;
		}else{
			log.info("CompanyUserServiceImpl--getCompanyUserById 查询企业用户失败 参数错误 Id="+id);
			throw new PDServiceException("查询用户失败 参数错误 Id="+id,2000);
		}
	}
	@Override
	@Transactional
	public int saveCompanyUser(CompanyUserPo companyUserPo)
			throws PDServiceException {
		log.info("CompanyUserServiceImpl--saveCompanyUser 参数 userPo="+companyUserPo.toString());
		try{
			/**
			 * 将用户名和密码分别进行base64加密然后再加上所调用的接口名称
			 */
			String str=new sun.misc.BASE64Encoder().encode(companyUserPo.getUserName().getBytes())+new sun.misc.BASE64Encoder().encode(companyUserPo.getPassWord().getBytes())+"pands/login.shtml";
			/**
			 * 将加密后的字符串str进行md5加密并验证秘钥是否正确
			 */
			MessageDigest md= MessageDigest.getInstance("MD5");
			md.update(str.getBytes());   
			String check= new BigInteger(1, md.digest()).toString(16);
			companyUserPo.setPassWord(check);
			int code=companyUserMapper.saveCompanyUser(companyUserPo);
			log.info("CompanyUserServiceImpl--saveCompanyUser return code="+code);
			return code;
		}catch(Exception e){
			log.info("CompanyUserServiceImpl--saveCompanyUser 保存用户失败   +errorMeg="+e.getMessage());
			throw new PDServiceException("保存用户失败",4000);
		}
	}
}
