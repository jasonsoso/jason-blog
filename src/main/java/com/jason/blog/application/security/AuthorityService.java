package com.jason.blog.application.security;

import java.util.List;
import java.util.Map;

import com.jason.blog.domain.security.authority.Authority;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;

public interface AuthorityService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Authority get(String id);

	/**
	 * 
	 * @param entity
	 */
	void store(Authority entity);

	/**
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	List<Authority> query(String queryString, Object... values);

	/**
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	Page<Authority> queryPage(Page<Authority> page, String hql, Map<String, Object> values);
}
