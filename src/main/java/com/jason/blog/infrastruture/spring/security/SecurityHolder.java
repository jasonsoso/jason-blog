package com.jason.blog.infrastruture.spring.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.infrastruture.spring.security.userdetails.UserDetailsServiceImpl.UserDetailsImpl;

public class SecurityHolder {
	/**
	 * 
	 * @return
	 */
	public static String getCurrentUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null == authentication)
			return "";
		return authentication.getName();
	}

	/**
	 * 
	 * @return
	 */
	public static UserInfo getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (null == principal) {
			return null;
		}

		if (principal instanceof UserDetailsImpl) {

			UserDetailsImpl userDetailsImpl = (UserDetailsImpl) principal;
			return userDetailsImpl.getUserInfo();
		}

		return null;
	}
}
