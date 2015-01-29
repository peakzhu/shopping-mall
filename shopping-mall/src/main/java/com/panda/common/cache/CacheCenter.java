package com.panda.common.cache;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.stereotype.Component;

import com.panda.user.po.UserPo;

@Component
public class CacheCenter {

	/**
	 * 用户信息缓存。
	 */
	@Resource(name="userLoginCache")
	private Cache userLoginCache;
	/**
	 * 添加用户登陆信息缓存。
	 * @param key sid
	 * @param value 
	 * @return
	 */
	public boolean addUserInfo(String key, UserPo value)
	{
		if (this.isNotEmpty(userLoginCache))
		{
			Element element = new Element(key, value);
			userLoginCache.put(element);
			return true;
		}
		return false;
	}
	
	/**
	 * 移除缓存 包括用户登陆信息，用户信息
	 * @param key
	 * @return
	 */
	public synchronized boolean removeUserInfo(String key)
	{
		if (this.isNotEmpty(userLoginCache))
		{
			userLoginCache.remove(key);
			return true;
		}
		return false;
	}
	
	/**
	 * 获取用户登录信息。
	 * @param key sid
	 * @return 
	 */
	public UserPo getUserInfo(String key)
	{
		if (this.isNotEmpty(userLoginCache))
		{
			Element element = userLoginCache.get(key);
			if (null != element)
			{
				return (UserPo)element.getObjectValue();
			}
		}
		return null;
	}
	
	
	/**
	 * 更新用户登录信息缓存。
	 * @param key sid
	 * @param value 用户对象
	 * @return
	 */
	public synchronized boolean updateUserInfo(String key, UserPo value)
	{
		if (this.isNotEmpty(userLoginCache))
		{
			Element element = new Element(key, value);
			userLoginCache.remove(key);
			userLoginCache.put(element);
			return true;
		}
		return false;
	}
	
	
	/**
	 * 验证cache是否为空。
	 * @param cache
	 * @return
	 */
	private boolean isNotEmpty(Cache cache)
	{
		return null != cache ? true : false;
	}
}
