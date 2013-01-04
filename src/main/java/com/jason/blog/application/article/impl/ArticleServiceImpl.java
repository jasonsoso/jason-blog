package com.jason.blog.application.article.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jason.blog.application.article.ArticleService;
import com.jason.blog.domain.article.Article;
import com.jason.blog.domain.article.ArticleRepository;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;

@Transactional
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleRepository articleRepository;

	@Autowired
	public void setUserInfoRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public void delete(long id) {
		articleRepository.delete(id);
	}

	@Override
	public void store(Article entity) {
		articleRepository.store(entity);
	}

	@Override
	public Article get(long id) {
		return articleRepository.get(id);
	}

	@Override
	public List<Article> query(String queryString, Object... values) {
		return articleRepository.query(queryString, values);
	}

	@Override
	public Page<Article> queryPage(Page<Article> page, String hql, Map<String, Object> values) {
		return articleRepository.queryPage(page, hql, values);
	}

}
