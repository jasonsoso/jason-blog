package com.jason.blog.infrastruture.spring.security.metadatasource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;


/**
 * URL 拦截
 * @author Jason
 *
 */
public class URLSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	private final static PathMatcher pathMatcher =  new AntPathMatcher();
	
	@Autowired
	private ResourceMetadataService resourceMetadataService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#getAttributes (java.lang.Object)
	 */
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		FilterInvocation invocation = (FilterInvocation) object;
		String requestUrl = invocation.getRequestUrl();
		
		//resource --> authorities
		Map<String, Collection<String>> metadatas = resourceMetadataService.getMetadatas();
		Iterator<String> it = metadatas.keySet().iterator();

		while (it.hasNext()) {
			
			String urlPattern = it.next();
			
			//if (URL_MATCHER.pathMatchesUrl(urlPattern, requestUrl)) {
			if (pathMatcher.match(urlPattern, requestUrl)) {
				Collection<ConfigAttribute> configAttrs = new ArrayList<ConfigAttribute>();
				
				for (String metadata : metadatas.get(urlPattern)) {
					configAttrs.add(new SecurityConfig(metadata));
				}
				
				return configAttrs;
			}
		}
		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource# getAllConfigAttributes()
	 */
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		Map<String, Collection<String>> metadatas = resourceMetadataService.getMetadatas();
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		
		for (Collection<String> metadataAsCollection : metadatas.values()) {
			
			for (String metadata : metadataAsCollection) {
				configAttributes.add(new SecurityConfig(metadata));
			}
		}
		
		return configAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#supports(java .lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
