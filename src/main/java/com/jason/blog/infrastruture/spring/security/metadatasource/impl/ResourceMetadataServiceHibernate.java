package com.jason.blog.infrastruture.spring.security.metadatasource.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.domain.security.resource.ResourceRepository;
import com.jason.blog.infrastruture.persist.hibernate.CacheRegions;
import com.jason.blog.infrastruture.spring.security.metadatasource.ResourceMetadataService;


@Component
public class ResourceMetadataServiceHibernate implements ResourceMetadataService {

	@Autowired
	private ResourceRepository resourceRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.forgov.sharpc.infrastruture.spring.security.metadatasource.ResourceMetadataService#getMetadatas ()
	 */
	@Transactional(readOnly = true)
	public Map<String, Collection<String>> getMetadatas() {

		List<Resource> resources = resourceRepository.queryOnCache(
																	CacheRegions.QUERY_SECURITY_RESOURCE.cacheRegion(),
																	"select distinct r from Resource r left join fetch r.authorities"
																);

		Map<String, Collection<String>> metadatas = new LinkedHashMap<String, Collection<String>>();

		// resource --> authority
		for (Resource resource : resources) {
			metadatas.put(resource.getValue(), resource.getAuthorityNames());
		}

		return metadatas;
	}

}
