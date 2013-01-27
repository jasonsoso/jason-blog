package com.jason.blog.domain.article;

import java.util.List;
import java.util.Map;

import com.jason.blog.infrastruture.persist.hibernate.query.Page;

/**
 * 
 * @author Jason
 * @date 2013-1-27 上午10:47:25
 */
public interface ArticleRepository {

	Article get(Long id);

	void store(Article entity);

	void delete(Long id);

	List<Article> query(String queryString, Object... values);

	Page<Article> queryPage(Page<Article> page, String hql, Map<String, Object> values);
	
	Object queryUnique(String queryString, Object... values);
}
