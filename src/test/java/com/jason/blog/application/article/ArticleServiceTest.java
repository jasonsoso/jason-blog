package com.jason.blog.application.article;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.application.AbstractTestBase;
import com.jason.blog.domain.article.Article;

public class ArticleServiceTest extends AbstractTestBase {

	@Autowired
	private ArticleService articleService;
	
	@Test
	public void testGet(){
		Article article = articleService.get(0L);
		Assert.assertNull(article);
	}
	
	@Test
	@Rollback(true)
	public void testStore(){
		Article entity = new Article();
		entity.setTitle("title~~");
		entity.setSummary("summary~~");
		entity.setContent("content~~");
		entity.setOnTop(true);
		entity.setCreatedAt(new Date());
		entity.setUpdatedAt(new Date());
		
		articleService.store(entity);
		System.out.println("testStore id is :"+entity.getId());
	}
	
	@Test
	@Rollback(false)
	public void testUpdate(){
		Page<Article> page = new Page<Article>().setPageNo(1).setPageSize(10);
		HQLQuery query = new HQLQuery().table("Article").orderBy("id");
		page = articleService.queryPage(page, query.hql(), query.values());
		
		for (Article article : page.getResult()) {
			articleService.store(article);
		}
		
	}
	
}
