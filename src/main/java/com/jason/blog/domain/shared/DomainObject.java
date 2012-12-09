package com.jason.blog.domain.shared;

public interface DomainObject<T> {
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	boolean sameIdentityAs(T other);
}
