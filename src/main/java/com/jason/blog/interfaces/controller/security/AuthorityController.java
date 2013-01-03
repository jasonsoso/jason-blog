package com.jason.blog.interfaces.controller.security;

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

import com.jason.blog.application.security.AuthorityService;
import com.jason.blog.application.security.ResourceService;
import com.jason.blog.domain.security.authority.Authority;
import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.domain.shared.EntityUtils;
import com.jason.blog.infrastruture.persist.hibernate.HibernateHelper;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery.MatchType;
import com.jason.blog.interfaces.support.ControllerSupport;


@Controller
@RequestMapping(value = "/security/authority")
public class AuthorityController extends ControllerSupport {
	private static final String REDIRECT_LIST = "redirect:/security/authority/list";

	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private ResourceService resourceService;
	/**
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Page<Authority> page, HttpServletRequest request, Model model) {

		HQLQuery query = new HQLQuery().table("Authority")
										.or(
												new String[] { "name", "displayName" },
												new MatchType[] { MatchType.LIKE, MatchType.LIKE },
												new Object[] { request.getParameter("name"), request.getParameter("name") }
										)
										.orderBy("name");

		page = authorityService.queryPage(page, query.hql(), query.values());
		model.addAttribute(page);
		return "security/authority/list";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {

		model.addAttribute(new Authority()).addAttribute("resourceList", resourceService.query("from Resource"));
		return "security/authority/form";
	}

	/**
	 * 
	 * @param entity
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Authority entity, BindingResult result, HttpServletRequest request,Model model,RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("resourceList", resourceService.query("from Resource"));
			error(model, "创建权限失败，请核对数据!");
			return "security/authority/form";
		}

		HibernateHelper.mergeByIds(
									entity.getResources(),
									entity.getResourceMap().values(),
									Resource.class
								);
		authorityService.store(entity);
		success(redirectAttributes,"创建权限成功！");
		return REDIRECT_LIST;
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {

		model.addAttribute("_method", "put")
				.addAttribute(authorityService.get(id).fillupResourceMap())
				.addAttribute("resourceList", resourceService.query("from Resource"));

		return "security/authority/form";
	}

	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public String edit(@PathVariable("id") String id, HttpServletRequest request,RedirectAttributes redirectAttributes) {
		try {
			Authority entity = authorityService.get(id);
			bind(request, entity);

			HibernateHelper.mergeByIds(
										entity.getResources(),
										entity.getResourceMap().values(),
										Resource.class
									);
			
			authorityService.store(entity);
			success(redirectAttributes,"权限修改成功！");
		} catch (Exception e) {
			error(redirectAttributes,"修改权限失败，请核实数据后重新提交！");
		}
		return REDIRECT_LIST;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(HttpServletRequest request,RedirectAttributes redirectAttributes) {

		String[] items = EntityUtils.nullSafe(request.getParameterValues("items"), new String[] {});

		for (String item : items) {
			authorityService.delete(item);
		}
		success(redirectAttributes,"删除权限成功！");
		return REDIRECT_LIST;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id,RedirectAttributes redirectAttributes) {
		
		authorityService.delete(id);
		success(redirectAttributes,"删除权限成功！");
		return REDIRECT_LIST;
	}

}
