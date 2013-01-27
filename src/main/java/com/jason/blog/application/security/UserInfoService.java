package com.jason.blog.application.security;

import java.util.List;
import java.util.Map;

import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;


public interface UserInfoService {

	/**
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 
	 * @param entity
	 */
	void store(UserInfo entity);

	/**
	 * 
	 * @param id
	 * @return
	 */
	UserInfo get(Long id);
	/**
	 * 
	 * @param username
	 * @return
	 */
	UserInfo queryByName(String username);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	List<UserInfo> query(String queryString, Object... values);

	/**
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	Page<UserInfo> queryPage(Page<UserInfo> page, String hql, Map<String, Object> values);

}
