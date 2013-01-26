package com.jason.blog.interfaces.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jason.blog.application.article.ArticleService;
import com.jason.blog.application.security.UserInfoService;
import com.jason.blog.domain.article.Article;
import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.interfaces.support.ControllerSupport;



/**
 * 
 * @author Jason
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends ControllerSupport {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private ArticleService articleService;

	/*--------------------华丽的分割------------------------*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String index(@PathVariable("id")Long id,Model model){
		return blogList(id, 1, model);
	}
	
	@RequestMapping(value = "/{id}/blog", method = RequestMethod.GET)
	public String blogList(@PathVariable("id")Long id,Model model){
		return blogList(id, 1, model);
	}
	
	@RequestMapping(value = "/{id}/blog/page/{pageNo}", method = RequestMethod.GET)
	public String blogList(@PathVariable("id")Long id,@PathVariable("pageNo")int pageNo,Model model) {
		Page<Article> page = new Page<Article>().setPageNo(pageNo).setPageSize(2);
		
		UserInfo user = userInfoService.get(id);
		if(null != user){
			HQLQuery query = new HQLQuery().table("select a from Article a join a.user u")
											.eq("u.id", id)
											.orderBy("a.createdAt desc");
			
			page = articleService.queryPage(page, query.hql(), query.values());
			model.addAttribute(page).addAttribute("user",user);
		}
		
		return "WEB-INF/front/template/user";
	}

}
