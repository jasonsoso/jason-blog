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

import com.jason.blog.application.security.AuthorityService;
import com.jason.blog.application.security.RoleService;
import com.jason.blog.domain.security.authority.Authority;
import com.jason.blog.domain.security.role.Role;
import com.jason.blog.domain.shared.EntityUtils;
import com.jason.blog.infrastruture.persist.hibernate.HibernateHelper;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.interfaces.support.ControllerSupport;


@Controller
@RequestMapping(value = "/security/role")
public class RoleController extends ControllerSupport {
	private static final String REDIRECT_LIST = "redirect:/security/role/list";
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthorityService authorityService;

	/**
	 * role list
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Page<Role> page, HttpServletRequest request, Model model) {
		
		HQLQuery query = new HQLQuery().table("Role")
										.like("name", request.getParameter("name"));
		
		page = roleService.queryPage(page, query.hql(), query.values());
		model.addAttribute(page);
		return "security/role/list";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute(new Role()).addAttribute("authorityList", authorityService.query("from Authority"));
		return "security/role/form";
	}

	/**
	 * 
	 * @param entity
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Role entity, BindingResult result, HttpServletRequest request,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("authorityList", authorityService.query("from Authority"));
			error(model, "创建角色失败，请核对数据!");
			return "security/role/form";
		}

		HibernateHelper.mergeByIds(
									entity.getAuthorities(),
									entity.getAuthorityMap().values(),
									Authority.class
								);
		roleService.store(entity);
		success("创建角色成功！");
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
				.addAttribute(roleService.get(id).fillupAuthorityMap())
				.addAttribute("authorityList", authorityService.query("from Authority"));
		return "security/role/form";
	}

	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public String edit(@PathVariable("id") String id, HttpServletRequest request) {
		try {
			Role entity = roleService.get(id);
			bind(request, entity);

			HibernateHelper.mergeByIds(
										entity.getAuthorities(),
										entity.getAuthorityMap().values(),
										Authority.class
									);
			roleService.store(entity);
			success("角色修改成功！");
		} catch (Exception e) {
			error("修改角色失败，请核实数据后重新提交！");
		}

		return REDIRECT_LIST;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(HttpServletRequest request) {
		String[] items = EntityUtils.nullSafe(request.getParameterValues("items"), new String[] {});
		for (String item : items) {
			delete(item);
		}
		success("删除角色成功！");
		return REDIRECT_LIST;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id) {
		roleService.delete(id);
		success("删除角色成功！");
		return REDIRECT_LIST;
	}

}
