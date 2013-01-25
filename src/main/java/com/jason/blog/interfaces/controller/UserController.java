package com.jason.blog.interfaces.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jason.blog.application.security.UserInfoService;
import com.jason.blog.domain.security.user.UserInfo;
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

	/*--------------------华丽的分割------------------------*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model model) {
		UserInfo user = userInfoService.get(id);
		model.addAttribute("user",user);
		return "WEB-INF/front/template/user";
	}

}
