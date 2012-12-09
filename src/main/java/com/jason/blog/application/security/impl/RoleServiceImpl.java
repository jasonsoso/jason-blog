package com.jason.blog.application.security.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jason.blog.application.security.RoleService;
import com.jason.blog.domain.security.role.Role;
import com.jason.blog.domain.security.role.RoleRepository;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;

@Transactional
public class RoleServiceImpl implements RoleService {
	private RoleRepository roleRepository;

	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public void delete(String id) {
		roleRepository.delete(id);
	}

	@Override
	public void store(Role entity) {
		roleRepository.store(entity);
	}

	@Override
	public Role get(String id) {
		return roleRepository.get(id);
	}

	@Override
	public List<Role> query(String queryString, Object... values) {
		return roleRepository.query(queryString, values);
	}

	@Override
	public Page<Role> queryPage(Page<Role> page, String hql, Map<String, Object> values) {
		return roleRepository.queryPage(page, hql, values);
	}

}
