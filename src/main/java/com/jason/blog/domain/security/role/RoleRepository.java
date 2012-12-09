package com.jason.blog.domain.security.role;

import java.util.List;
import java.util.Map;

import com.jason.blog.infrastruture.persist.hibernate.query.Page;


public interface RoleRepository {

	void delete(String id);

	void store(Role entity);

	Role get(String id);

	List<Role> query(String queryString, Object... values);

	Page<Role> queryPage(Page<Role> page, String hql, Map<String, Object> values);
}
