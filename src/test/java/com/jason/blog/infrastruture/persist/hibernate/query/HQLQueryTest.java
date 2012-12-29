package com.jason.blog.infrastruture.persist.hibernate.query;

import junit.framework.Assert;
import org.junit.Test;

public class HQLQueryTest {

	/**
	 * 测试 简单拼装SQL语句
	 */
	@Test
	public void testSQL() {
		HQLQuery query = new HQLQuery().table("UserInfo")
			.like("username", "test")
			.orderBy("username");
		
		System.out.println(query.hql()+" "+query.values());
		Assert.assertEquals("from UserInfo where username like :username order by username ", query.hql());
		
	}

}
