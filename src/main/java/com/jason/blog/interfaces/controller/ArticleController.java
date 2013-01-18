package com.jason.blog.interfaces.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jason.blog.application.article.ArticleService;
import com.jason.blog.domain.article.Article;
import com.jason.blog.domain.shared.EntityUtils;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.infrastruture.spring.security.SecurityHolder;
import com.jason.blog.interfaces.support.ControllerSupport;



/**
 * 
 * 文章管理的Controller, 使用Restful风格的Urls:
 * 
 * List   page        : GET  /article/list
 * Create page        : GET  /article/create
 * Create action      : POST /article/create
 * Show   page        : GET  /article/{id}
 * Update page        : GET  /article/{id}/edit
 * Update action      : PUT  /article/{id}/edit
 * Delete action      : DELETE /article/{id}/delete
 * Delete many action : DELETE /article/delete
 * 
 * @author Jason
 *
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController extends ControllerSupport {
	
	private static final String REDIRECT_LIST = "redirect:/article/list";
	
	@Autowired
	private ArticleService articleService;

	/**
	 * article list
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Page<Article> page, HttpServletRequest request, Model model) {

		HQLQuery query = new HQLQuery().table("Article")
									.orderBy("id");
		page = articleService.queryPage(page, query.hql(), query.values());
		
		model.addAttribute(page);
		return "article/list";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute(new Article());
		return "article/form";
	}

	/**
	 * @param entity
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Article entity, BindingResult result, HttpServletRequest request,Model model,RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			error(model, "创建文章失败，请核对数据!");
			return "article/form";
		}
		Date now = new Date();
		entity.setCreatedAt(now);
		entity.setUpdatedAt(now);
		entity.setUser(SecurityHolder.getCurrentUser());
		
		articleService.store(entity);
		
		success(redirectAttributes,"创建文章成功！"); 
		return REDIRECT_LIST;
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) {

		model.addAttribute("_method", "put")
				.addAttribute(articleService.get(id));
		return "article/form";
	}

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public String edit(@PathVariable("id") long id, HttpServletRequest request,RedirectAttributes redirectAttributes) {
		try {
			Article entity = articleService.get(id);

			bind(request, entity);
			entity.setUpdatedAt(new Date());
			articleService.store(entity);
			success(redirectAttributes,"文章修改成功！");
		} catch (Exception e) {
			error(redirectAttributes,"修改文章失败，请核实数据后重新提交！");
		}
		return REDIRECT_LIST;
	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(HttpServletRequest request,RedirectAttributes redirectAttributes) {

		String[] items = EntityUtils.nullSafe(request.getParameterValues("items"), new String[] {});
		for (String item : items) {
			articleService.delete(Integer.parseInt(item));
		}
		success(redirectAttributes,"删除文章成功！");
		return REDIRECT_LIST;
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") long id,RedirectAttributes redirectAttributes) {
		articleService.delete(id);
		success(redirectAttributes,"删除文章成功！");
		return REDIRECT_LIST;
	}
	
	//----------------------------- 华丽的 分割符号--------------------------------
	
	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") long id, Model model) {
		Article article = articleService.get(id);
		Article prev = articleService.getPrev(article);
		Article next = articleService.getNext(article);
		model.addAttribute(article)
			 .addAttribute("prev",prev)
			 .addAttribute("next",next);
		return "WEB-INF/front/template/show";
	}
	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "WEB-INF/front/template/index";
	}
	
	
}
