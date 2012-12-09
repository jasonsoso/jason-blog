package com.jason.blog.application.security;

import java.util.List;
import java.util.Map;

import com.jason.blog.domain.security.role.Role;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;


public interface RoleService {

	/**
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * 
	 * @param entity
	 */
	void store(Role entity);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Role get(String id);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	List<Role> query(String queryString, Object... values);

	Page<Role> queryPage(Page<Role> page, String hql, Map<String, Object> values);

}
