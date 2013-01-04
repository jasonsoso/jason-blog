package com.jason.blog.domain.article;

import java.util.List;
import java.util.Map;

import com.jason.blog.infrastruture.persist.hibernate.query.Page;



public interface ArticleRepository {

	Article get(long id);

	void store(Article entity);

	void delete(long id);

	List<Article> query(String queryString, Object... values);

	Page<Article> queryPage(Page<Article> page, String hql, Map<String, Object> values);
}
