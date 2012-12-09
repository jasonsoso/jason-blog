package com.jason.blog.domain.security.authority;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.domain.shared.AbstractDomainObject;
import com.jason.blog.infrastruture.util.ConvertUtils;


public class Authority extends AbstractDomainObject {
	private static final long serialVersionUID = 1L;
	private Set<Resource> resources = new HashSet<Resource>();

	public Set<Resource> getResources() {
		if (null == resources) {
			return Collections.emptySet();
		}
		return resources;
	}

	public Set<String> getResourceValues() {
		Set<String> resourceValues = new LinkedHashSet<String>();

		for (Resource resource : getResources()) {
			resourceValues.add(resource.getValue());
		}

		return resourceValues;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	private Map<String, String> resourceMap = new HashMap<String, String>();

	public Map<String, String> getResourceMap() {
		if (null == resourceMap) {
			return Collections.emptyMap();
		}
		return resourceMap;
	}

	public Authority setResourceMap(Map<String, String> resourceMap) {
		this.resourceMap = resourceMap;
		return this;
	}

	public Authority fillupResourceMap() {
		Map<String, String> resourceMap = new HashMap<String, String>();
		ConvertUtils.convertPropertyToMap(getResources(), "id", "id", resourceMap);
		return setResourceMap(resourceMap);
	}
	
	private String name;
	private String displayName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
