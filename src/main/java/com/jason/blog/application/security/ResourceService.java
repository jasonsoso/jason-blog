package com.jason.blog.application.security;

import java.util.List;
import java.util.Map;

import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;


public interface ResourceService {

	/**
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Resource get(String id);

	/**
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	Page<Resource> queryPage(Page<Resource> page, String hql, Map<String, Object> values);

	/**
	 * 
	 * @param entity
	 */
	void store(Resource entity);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	List<Resource> query(String queryString, Object... values);
}
