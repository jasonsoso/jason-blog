package com.jason.blog.domain.security.authority;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.domain.shared.AbstractDomainObject;
import com.jason.blog.infrastruture.util.ConvertUtils;


public class Authority extends AbstractDomainObject {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="权限名不能为空！")
	@Size(min = 1,message="权限名不能为空！")
	private String name;
	
	@NotNull(message="显示名称不能为空！")
	@Size(min = 1,message="显示名称不能为空！")
	private String displayName;
	
	private Set<Resource> resources = new HashSet<Resource>();
	
	private Map<String, String> resourceMap = new HashMap<String, String>();
	
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

	public Authority setResources(Set<Resource> resources) {
		this.resources = resources;
		return this;
	}

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
	


	public String getName() {
		return name;
	}

	public Authority setName(String name) {
		this.name = name;
		return this;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Authority setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

}
