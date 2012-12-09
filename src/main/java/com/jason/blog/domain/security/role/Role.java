package com.jason.blog.domain.security.role;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.jason.blog.domain.security.authority.Authority;
import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.domain.shared.AbstractDomainObject;
import com.jason.blog.infrastruture.util.ConvertUtils;


public class Role extends AbstractDomainObject  {
	private static final long serialVersionUID = 1L;

	private Set<UserInfo> users = new HashSet<UserInfo>();

	public Set<UserInfo> getUsers() {
		if (null == users) {
			return Collections.emptySet();
		}
		return users;
	}

	public Role setUsers(Set<UserInfo> users) {
		this.users = users;
		return this;
	}

	private Set<Authority> authorities = new HashSet<Authority>();

	public Set<Authority> getAuthorities() {
		if (null == authorities) {
			return Collections.emptySet();
		}
		return authorities;
	}

	public Role setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
		return this;
	}

	private Map<String, String> authorityMap = new HashMap<String, String>();

	public Map<String, String> getAuthorityMap() {
		if (null == authorityMap) {
			return Collections.emptyMap();
		}
		return authorityMap;
	}

	public Role setAuthorityMap(Map<String, String> authorityMap) {
		this.authorityMap = authorityMap;
		return this;
	}

	public Role fillupAuthorityMap() {
		Map<String, String> roleMap = new HashMap<String, String>();
		ConvertUtils.convertPropertyToMap(getAuthorities(), "id", "id", roleMap);
		return setAuthorityMap(roleMap);
	}

	private String name;
	private String descr;

	public String getName() {
		return name;
	}

	public Role setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescr() {
		return descr;
	}

	public Role setDescr(String descr) {
		this.descr = descr;
		return this;
	}

	@Override
	public String toString() {
		return getName();
	}
}
