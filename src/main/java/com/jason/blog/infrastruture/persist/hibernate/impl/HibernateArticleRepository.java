package com.jason.blog.infrastruture.persist.hibernate.impl;

import org.springframework.stereotype.Repository;
import com.jason.blog.domain.article.Article;
import com.jason.blog.domain.article.ArticleRepository;
import com.jason.blog.infrastruture.persist.hibernate.HibernateRepositorySupport;

@Repository
public class HibernateArticleRepository extends HibernateRepositorySupport<Long, Article> implements ArticleRepository {

	@Override
	public void delete(Long id) {
		super.delete(super.get(id));
	}
}
