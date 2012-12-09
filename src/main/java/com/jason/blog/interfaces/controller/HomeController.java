package com.jason.blog.interfaces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		return "admin/index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/admin/header", method=RequestMethod.GET)
	public String adminHeader() {
		return "admin/header";
	}
	
	@RequestMapping(value="/admin/left", method=RequestMethod.GET)
	public String adminLeft() {
		return "admin/left";
	}
	
	@RequestMapping(value="/admin/right", method=RequestMethod.GET)
	public String adminRight() {
		return "admin/right";
	}
	
	@RequestMapping(value="/admin/footer", method=RequestMethod.GET)
	public String adminFooter() {
		return "admin/footer";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		return "login";
	}
}

