package com.jason.blog.domain.security.resource;

import java.util.List;
import java.util.Map;

import com.jason.blog.infrastruture.persist.hibernate.query.Page;


public interface ResourceRepository {

	List<Resource> queryOnCache(String cacheRegion, String queryString, Object... values);

	void delete(String id);

	Resource get(String id);

	Page<Resource> queryPage(Page<Resource> page, String hql, Map<String, Object> values);

	void store(Resource entity);

	List<Resource> query(String queryString, Object... values);
}
