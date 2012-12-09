package com.jason.blog.application.security.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jason.blog.application.security.ResourceService;
import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.domain.security.resource.ResourceRepository;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;

@Transactional
public class ResourceServiceImpl implements ResourceService {
	private ResourceRepository resourceRepository;

	@Autowired
	public void setResourceRepository(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	@Override
	public void delete(String id) {
		resourceRepository.delete(id);
	}

	@Override
	public Resource get(String id) {
		return resourceRepository.get(id);
	}

	@Override
	public Page<Resource> queryPage(Page<Resource> page, String hql, Map<String, Object> values) {
		return resourceRepository.queryPage(page, hql, values);
	}

	@Override
	public void store(Resource entity) {
		resourceRepository.store(entity);
	}

	@Override
	public List<Resource> query(String queryString, Object... values) {
		return resourceRepository.query(queryString,values);
	}

}
