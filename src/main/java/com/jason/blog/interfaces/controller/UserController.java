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
import com.jason.blog.interfaces.exception.ResourceNotFoundException;
import com.jason.blog.interfaces.support.ControllerSupport;


/**
 * 个人中心 个人首页 个人博客首页
 * @author Jason
 * @date 2013-1-27 下午08:56:37
 */
@Controller
public class UserController extends ControllerSupport {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private ArticleService articleService;

	/*--------------------华丽的分割------------------------*/
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String index(@PathVariable("username")String username,Model model){
		return blogList(username, 1, model);
	}

	@RequestMapping(value = "/{username}/page/{pageNo}", method = RequestMethod.GET)
	public String blogList(@PathVariable("username")String username,@PathVariable("pageNo")int pageNo,Model model) {
		Page<Article> page = new Page<Article>().setPageNo(pageNo).setPageSize(5);
		
		UserInfo user = userInfoService.queryByName(username);
		
		if(null != user){
			HQLQuery query = new HQLQuery().table("select a from Article a join a.user u")
											.eq("u.username", username)
											.orderBy("a.createdAt desc");
			
			page = articleService.queryPage(page, query.hql(), query.values());
			model.addAttribute(page).addAttribute("user",user);
		}else{
			throw new ResourceNotFoundException();//404
		}
		
		return "WEB-INF/front/template/user";
	}

}
