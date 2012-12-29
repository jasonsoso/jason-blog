package com.jason.blog.interfaces.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jason.blog.application.security.RoleService;
import com.jason.blog.application.security.UserInfoService;
import com.jason.blog.domain.security.role.Role;
import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.domain.shared.EntityUtils;
import com.jason.blog.infrastruture.persist.hibernate.HibernateHelper;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.interfaces.support.ControllerSupport;



@Controller
@RequestMapping(value = "/security/user")
public class UserController extends ControllerSupport {
	
	private static final String REDIRECT_LIST = "redirect:/security/user/list";
	
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RoleService roleService;

	/**
	 * user list
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Page<UserInfo> page, HttpServletRequest request, Model model) {

		HQLQuery query = null;
		if (StringUtils.isNotBlank(request.getParameter("roleId"))) {
			query = new HQLQuery().table("select u from UserInfo u join u.roles role")
									.like("username", request.getParameter("name"))
									.eq("role.id", request.getParameter("roleId"))
									.orderBy("u.username");
		} else {
			query = new HQLQuery().table("UserInfo")
									.like("username", request.getParameter("name"))
									.orderBy("username");
		}
		page = userInfoService.queryPage(page, query.hql(), query.values());
		model.addAttribute(page).addAttribute("roleList", roleService.query("from Role"));
		return "security/user/list";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute(new UserInfo()).addAttribute("roleList", roleService.query("from Role"));
		return "security/user/form";
	}

	/**
	 * @param entity
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid UserInfo entity, BindingResult result, HttpServletRequest request,Model model) {

		if (result.hasErrors()) {
			model.addAttribute("roleList", roleService.query("from Role"));
			error(model, "创建用户失败，请核对数据!");
			return "security/user/form";
		}
		HibernateHelper.mergeByIds(
									entity.getRoles(),
									entity.getRoleMap().values(),
									Role.class
								);
		entity.encodePassword(new Md5PasswordEncoder());
		userInfoService.store(entity);
		success("创建用户成功！");
		return REDIRECT_LIST;
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {

		model.addAttribute("_method", "put")
				.addAttribute(userInfoService.get(id).fillupRoleMap())
				.addAttribute("roleList", roleService.query("from Role"));
		return "security/user/form";
	}

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public String edit(@PathVariable("id") String id, HttpServletRequest request) {
		try {
			UserInfo entity = userInfoService.get(id);

			String origUsername = entity.getUsername();
			String origPassword = entity.getPassword();
			bind(request, entity);

			// prevent malicious request,if username has modify,throw exception
			if (usernameHasModified(origUsername, entity.getUsername())) {
				throw new UnsupportedOperationException("Cannot modify the username!");
			}

			HibernateHelper.mergeByIds(
										entity.getRoles(),
										entity.getRoleMap().values(),
										Role.class
									);

			if (passwordHasModified(origPassword, entity.getPassword())) {// user has modified password
				entity.encodePassword(new Md5PasswordEncoder());
			} else { // user didnot want to modify password
				entity.setPassword(origPassword);
			}
			userInfoService.store(entity);
			success("用户修改成功！");
		} catch (Exception e) {
			error("修改用户失败，请核实数据后重新提交！");
		}
		return REDIRECT_LIST;
	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(HttpServletRequest request) {

		String[] items = EntityUtils.nullSafe(request.getParameterValues("items"), new String[] {});
		for (String item : items) {
			delete(item);
		}
		success("删除用户成功！");
		return REDIRECT_LIST;
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id) {
		userInfoService.delete(id);
		success("删除用户成功！");
		return REDIRECT_LIST;
	}
	
	/**
	 * username  is modified
	 * @param origUsername
	 * @param newUsername
	 * @return
	 */
	private boolean usernameHasModified(String origUsername, String newUsername) {
		return !StringUtils.equals(origUsername, newUsername);
	}
	
	/**
	 * password is modified
	 * @param origPassword
	 * @param newPassword
	 * @return
	 */
	private boolean passwordHasModified(String origPassword, String newPassword) {
		return StringUtils.isNotBlank(newPassword) && !StringUtils.equals(origPassword, newPassword);
	}

}
