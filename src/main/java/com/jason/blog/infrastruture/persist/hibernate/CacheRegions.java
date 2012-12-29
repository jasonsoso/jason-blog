package com.jason.blog.infrastruture.persist.hibernate;


public enum CacheRegions {
	QUERY_SECURITY_RESOURCE("query.security.resource");

	private final String cacheRegion;

	private CacheRegions(final String cacheRegion) {
		this.cacheRegion = cacheRegion;
	}

	public String cacheRegion() {
		return cacheRegion;
	}
}
