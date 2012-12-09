package com.jason.blog.infrastruture.persist.hibernate.impl.security;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.domain.security.resource.ResourceRepository;
import com.jason.blog.infrastruture.persist.hibernate.HibernateRepositorySupport;

@Repository
public class HibernateResourceRepository extends HibernateRepositorySupport<String, Resource> implements ResourceRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> queryOnCache(String cacheRegion, String queryString, Object... values) {
		return createQuery(queryString, values).setCacheable(true).setCacheRegion(cacheRegion).list();
	}

	@Override
	public void delete(String id) {
		super.delete(super.get(id));
	}

}
