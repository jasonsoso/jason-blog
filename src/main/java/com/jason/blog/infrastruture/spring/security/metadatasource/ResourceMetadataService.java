package com.jason.blog.infrastruture.spring.security.metadatasource;

import java.util.Collection;
import java.util.Map;


public interface ResourceMetadataService {
	/**
	 * 
	 * @return
	 */
	public Map<String, Collection<String>> getMetadatas();
}
