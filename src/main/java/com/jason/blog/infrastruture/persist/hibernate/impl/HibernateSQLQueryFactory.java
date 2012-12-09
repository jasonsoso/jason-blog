package com.jason.blog.infrastruture.persist.hibernate.impl;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.jason.blog.domain.SQLQueryFactory;
import com.jason.blog.infrastruture.persist.hibernate.HibernateRepository;


@Repository
public class HibernateSQLQueryFactory extends HibernateRepository implements SQLQueryFactory {

	@Override
	public SQLQuery createSQLQuery(String sql) {
		return super.getSession().createSQLQuery(sql);
	}
}
