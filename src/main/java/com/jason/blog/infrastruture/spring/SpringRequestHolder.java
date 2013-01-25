
package com.jason.blog.infrastruture.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class SpringRequestHolder {
	
	/**
    * get request
    */
   public static HttpServletRequest getRequest(RequestAttributes requestAttributes) {
		return ((ServletRequestAttributes) requestAttributes).getRequest();
	}
   /**
    * get session
    */
   public static HttpSession getSession(){
   		HttpServletRequest request = getRequest(RequestContextHolder.currentRequestAttributes());
   		return  request.getSession();
   }
}
