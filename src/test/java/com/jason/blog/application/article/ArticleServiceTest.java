package com.jason.blog.application.article;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

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
		entity.setContent("content~~");
		entity.setOnTop(true);
		entity.setCreatedAt(new Date());
		entity.setUpdatedAt(new Date());
		
		articleService.store(entity);
		System.out.println("testStore id is :"+entity.getId());
	}
}
