package com.panda.user.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panda.common.cache.CacheCenter;
import com.panda.common.exception.PDServiceException;
import com.panda.common.util.IdentifyUtils;
import com.panda.common.vo.Page;
import com.panda.user.dao.CompanyUserMapper;
import com.panda.user.dao.UserMapper;
import com.panda.user.po.CompanyUserPo;
import com.panda.user.po.UserPo;
import com.panda.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CompanyUserMapper companyUserMapper;
	@Resource
	private CacheCenter cacheCenter;
	public static Logger log= LoggerFactory.getLogger("business-log");
	@Override
	@Transactional
	public String login(String loginName, String password, int type)
			throws PDServiceException {
		if(StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)){
			log.info("UserServiceImpl--login 用户登录  用户名或者密码为空");
			throw new PDServiceException("用户名或者密码为空!",2000);
		}
		try{
			if(type==1){
				UserPo po=userMapper.getUserByLoginName(loginName);
				if(po!=null){
					/**
					 * 将用户名和密码分别进行base64加密然后再加上所调用的接口名称
					 */
					String str=new sun.misc.BASE64Encoder().encode(loginName.getBytes())+new sun.misc.BASE64Encoder().encode(password.getBytes())+"pands/login.shtml";
					/**
					 * 将加密后的字符串str进行md5加密并验证秘钥是否正确
					 */
					MessageDigest md= MessageDigest.getInstance("MD5");
					md.update(str.getBytes());   
					String check= new BigInteger(1, md.digest()).toString(16); 
					if(check.equals(po.getLoginPassWord())){
						//TODO 生成sid
						po.setIdentify(IdentifyUtils.getIdentify(po.getId(), po.getLoginName(), po.getLoginPassWord()));
						cacheCenter.addUserInfo(po.getIdentify(), po);
						return po.getIdentify();
					}else{
						log.info("UserServiceImpl--login 用户登录  失败 用户名或密码错误!");
						throw new PDServiceException("用户名或密码错误!",2000);
					}
				}else{
					log.info("UserServiceImpl--login 用户名不存在!");
					throw new PDServiceException("用户名不存在 ",2000);
				}
			}else{
				CompanyUserPo po=companyUserMapper.getUserByUserName(loginName);
				if(po!=null){
					/**
					 * 将用户名和密码分别进行base64加密然后再加上所调用的接口名称
					 */
					String str=new sun.misc.BASE64Encoder().encode(loginName.getBytes())+new sun.misc.BASE64Encoder().encode(password.getBytes())+"pands/login.shtml";
					/**
					 * 将加密后的字符串str进行md5加密并验证秘钥是否正确
					 */
					MessageDigest md= MessageDigest.getInstance("MD5");
					md.update(str.getBytes());   
					String check= new BigInteger(1, md.digest()).toString(16); 
					if(check.equals(po.getPassWord())){
						//TODO 生成sid
						po.setIdentify(IdentifyUtils.getIdentify(po.getId(), po.getUserName(), po.getPassWord()));
						//cacheCenter.addUserInfo(po.getIdentify(), po);
						return po.getIdentify();
					}else{
						log.info("UserServiceImpl--login 用户登录  失败 用户名或密码错误!");
						throw new PDServiceException("用户名或密码错误!",2000);
					}
				}else{
					log.info("UserServiceImpl--login 用户名不存在!");
					throw new PDServiceException("用户名不存在 ",2000);
				}
			}
		}catch(Exception e){
			log.info("UserServiceImpl--login 用户登录  失败  errorMeg:"+e.getMessage());
			throw new PDServiceException("用户登录失败 ",2000);
		}
	}
	@Override
	@Transactional
	public UserPo getUserById(int id) throws PDServiceException{
			log.info("UserServiceImpl--getUserById 参数 id="+id);
		if(id>0){
			UserPo user=userMapper.getUserById(id);
			log.info("UserServiceImpl--getUserById return  user="+user.toString());
			return user;
		}else{
			log.info("UserServiceImpl--getUserById 查询用户失败 参数错误 userId="+id);
			throw new PDServiceException("查询用户失败 参数错误 userId="+id,2000);
		}
	}
	@Override
	@Transactional
	public int saveUser(UserPo userPo) throws PDServiceException{
			log.info("UserServiceImpl--saveUser 参数 userPo="+userPo.toString());
		try{
			/**
			 * 将用户名和密码分别进行base64加密然后再加上所调用的接口名称
			 */
			String str=new sun.misc.BASE64Encoder().encode(userPo.getLoginName().getBytes())+new sun.misc.BASE64Encoder().encode(userPo.getLoginPassWord().getBytes())+"pands/login.shtml";
			/**
			 * 将加密后的字符串str进行md5加密并验证秘钥是否正确
			 */
			MessageDigest md= MessageDigest.getInstance("MD5");
			md.update(str.getBytes());   
			String check= new BigInteger(1, md.digest()).toString(16);
			userPo.setLoginPassWord(check);
			int code=userMapper.saveUser(userPo);
			log.info("UserServiceImpl--saveUser return code="+code);
			return code;
		}catch(Exception e){
			log.info("UserServiceImpl--saveUser 保存用户失败   +errorMeg="+e.getMessage());
			throw new PDServiceException("保存用户失败",4000);
		}
	}
	@Override
	public Page<List<UserPo>> getUserPage(String loginName, String nickName,
			int curPage, int pageSize) throws PDServiceException {
		log.info("UserServiceImpl--getUserPage 参数=loginName"+loginName+";nickName:"+nickName);
		try{
			//对查询条件进行封装
			Map<String,String> map=new HashMap<String,String>();
			map.put("loginName",loginName);
			map.put("nickName",nickName);
			int totalCount = (int) userMapper.getUserAll(map);
			List<UserPo> list= null;
			if (curPage<0) {
				curPage=1;
			} 
			Page<List<UserPo>> page = new Page<List<UserPo>>(totalCount,curPage,pageSize,list);
			//将分页信息封装
			map.put("startPos",page.getStartPos()+"");
			map.put("pageSize",pageSize+"");
			list= userMapper.getUserPage(map);
			page.setData(list);
			return page;
		}catch(Exception e){
			log.info("UserServiceImpl--getUserPage 分页查询用户失败 errorMes:"+e.getMessage());
			throw new PDServiceException("分页查询用户失败",4000);
		}
	}
}
