package com.jason.blog.application.article.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jason.blog.application.article.ArticleService;
import com.jason.blog.domain.article.Article;
import com.jason.blog.domain.article.ArticleRepository;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.infrastruture.util.html.SubStringHTML;

@Transactional
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleRepository articleRepository;

	@Autowired
	public void setUserInfoRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public void delete(Long id) {
		articleRepository.delete(id);
	}

	@Override
	public void store(Article entity) {
		entity.setSummary(SubStringHTML.subStringHTML(entity.getContent(), 300));
		articleRepository.store(entity);
	}

	@Override
	public Article get(Long id) {
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

	/* (non-Javadoc)
	 * @see com.jason.blog.application.article.ArticleService#getPre(com.jason.blog.domain.article.Article)
	 */
	@Override
	public Article getPrev(Article article) {
		String hql = "select a from Article a where id=(select max(id) from Article where id < ? and user.id=?)";
		return (Article) articleRepository.queryUnique(hql, article.getId(),article.getUser().getId());
	}

	/* (non-Javadoc)
	 * @see com.jason.blog.application.article.ArticleService#getNext(com.jason.blog.domain.article.Article)
	 */
	@Override
	public Article getNext(Article article) {
		String hql = "select a from Article a where id=(select min(id) from Article where id > ? and user.id=?)";
		return (Article) articleRepository.queryUnique(hql, article.getId(),article.getUser().getId());
	}

}
