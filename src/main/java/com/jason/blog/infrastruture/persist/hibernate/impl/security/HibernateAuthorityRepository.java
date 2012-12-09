package com.jason.blog.infrastruture.persist.hibernate.impl.security;

import org.springframework.stereotype.Repository;

import com.jason.blog.domain.security.authority.Authority;
import com.jason.blog.domain.security.authority.AuthorityRepository;
import com.jason.blog.infrastruture.persist.hibernate.HibernateRepositorySupport;

@Repository
public class HibernateAuthorityRepository extends HibernateRepositorySupport<String, Authority> implements AuthorityRepository{

	@Override
	public void delete(String id) {
		super.delete(super.get(id));
	}
	
}
