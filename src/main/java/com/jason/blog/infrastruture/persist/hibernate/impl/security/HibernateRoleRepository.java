package com.jason.blog.infrastruture.persist.hibernate.impl.security;

import org.springframework.stereotype.Repository;

import com.jason.blog.domain.security.role.Role;
import com.jason.blog.domain.security.role.RoleRepository;
import com.jason.blog.infrastruture.persist.hibernate.HibernateRepositorySupport;
	
@Repository
public class HibernateRoleRepository extends HibernateRepositorySupport<String, Role> implements RoleRepository{

	@Override
	public void delete(String id) {
		super.delete(super.get(id));
	}
}
