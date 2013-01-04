package com.jason.blog.application.article;

import java.util.List;
import java.util.Map;

import com.jason.blog.domain.article.Article;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;


public interface ArticleService {

	/**
	 * 
	 * @param id
	 */
	void delete(long id);

	/**
	 * 
	 * @param entity
	 */
	void store(Article entity);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Article get(long id);

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	List<Article> query(String queryString, Object... values);

	/**
	 * 
	 * @param page
	 * @param hql
	 * @param values
	 * @return
	 */
	Page<Article> queryPage(Page<Article> page, String hql, Map<String, Object> values);

}
