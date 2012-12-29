package com.jason.blog.domain.security.resource;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.jason.blog.domain.security.authority.Authority;
import com.jason.blog.domain.shared.AbstractDomainObject;


public class Resource extends AbstractDomainObject{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="资源名不能为空！")
	private String name;
	
	@NotEmpty(message="链接不能为空！")
	private String value;
	
	private int priority;
	
	private Set<Authority> authorities = new HashSet<Authority>();

	public Set<Authority> getAuthorities() {
		if (null == authorities) {
			return Collections.emptySet();
		}
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Set<String> getAuthorityNames() {
		Set<String> authorityNames = new LinkedHashSet<String>();
		for (Authority authority : getAuthorities()) {
			authorityNames.add(authority.getName());
		}

		return authorityNames;
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
