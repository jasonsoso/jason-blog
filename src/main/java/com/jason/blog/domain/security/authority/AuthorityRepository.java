package com.jason.blog.domain.security.authority;

import java.util.List;
import java.util.Map;

import com.jason.blog.infrastruture.persist.hibernate.query.Page;


public interface AuthorityRepository {

	Authority get(String id);

	void store(Authority entity);

	void delete(String id);

	List<Authority> query(String queryString, Object... values);

	Page<Authority> queryPage(Page<Authority> page, String hql, Map<String, Object> values);
}
