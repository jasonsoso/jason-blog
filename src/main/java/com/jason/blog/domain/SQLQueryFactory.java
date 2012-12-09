package com.jason.blog.domain;

public interface SQLQueryFactory {
	
	/**
	 * 
	 * @param sql
	 * @return the sql query.e.g:SQLQuery or prepareStatement.
	 */
	Object createSQLQuery(String sql);
}
