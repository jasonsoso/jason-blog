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

import com.jason.blog.application.security.ResourceService;
import com.jason.blog.domain.security.resource.Resource;
import com.jason.blog.domain.shared.EntityUtils;
import com.jason.blog.infrastruture.persist.hibernate.query.HQLQuery;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;
import com.jason.blog.interfaces.support.ControllerSupport;



@Controller
@RequestMapping(value = "/security/resource")
public class ResourceController extends ControllerSupport {
	private static final String REDIRECT_LIST = "redirect:/security/resource/list";
	
	@Autowired
	private ResourceService resourceService;

	/**
	 * resource list
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Page<Resource> page, HttpServletRequest request, Model model) {

		HQLQuery query = new HQLQuery().table("Resource")
										.like("name", request.getParameter("name"))
										.orderBy("priority asc");

		page = resourceService.queryPage(page, query.hql(), query.values());
		model.addAttribute(page);
		return "security/resource/list";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute(new Resource());
		return "security/resource/form";
	}

	/**
	 * @param entity
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid Resource entity, BindingResult result,Model model) {

		if (result.hasErrors()) {
			error(model, "创建资源失败，请核对数据!");
			return "security/resource/form";
		}
		success("创建资源成功！");
		resourceService.store(entity);
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
				.addAttribute(resourceService.get(id));
		return "security/resource/form";
	}

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public String edit(@PathVariable("id") String id, HttpServletRequest request) {
		try {

			Resource entity = resourceService.get(id);
			bind(request, entity);
			resourceService.store(entity);
			success("资源修改成功！");
		} catch (Exception e) {
			error("修改资源失败，请核实数据后重新提交！");
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
		success("删除资源成功！");
		return REDIRECT_LIST;
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id) {

		resourceService.delete(id);
		success("删除资源成功！");
		return REDIRECT_LIST;
	}

}
