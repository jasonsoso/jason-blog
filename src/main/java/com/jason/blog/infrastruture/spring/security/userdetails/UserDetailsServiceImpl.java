package com.jason.blog.infrastruture.spring.security.userdetails;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.domain.security.user.UserInfoRepository;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		UserInfo userInfo = userInfoRepository.queryByName(username);
		if (null == userInfo) {
			throw new UsernameNotFoundException("Invalid username");
		}

		List<GrantedAuthority> grantedAuthorities = obtainGrantedAuthorities(userInfo);
		
		UserDetailsImpl details = new UserDetailsImpl(userInfo.getUsername(),
														userInfo.getPassword(),
														userInfo.isEnabled(),
														userInfo.isAccountNonExpired(),
														userInfo.isCredentialsNonExpired(), 
														userInfo.isAccountNonLocked(),
														grantedAuthorities);
		details.setUserInfo(userInfo);

		return details;
	}

	// access resource need authorities
	// if(accessNeedAuthorities.removeAll(userGrantedAuthorities).size()>0) it may be deny this
	// access!
	private List<GrantedAuthority> obtainGrantedAuthorities(UserInfo userInfo) {

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		for (String authority : userInfo.getAuthorityNames()) {
			grantedAuthorities.add(new GrantedAuthorityImpl(authority));
		}

		return grantedAuthorities;
	}

	/**
	 * 
	 * @author loudyn
	 * 
	 */
	@SuppressWarnings("serial")
	public class UserDetailsImpl extends User {

		public UserDetailsImpl(String username, 
							   	String password, 
							   	boolean enabled, 
							   	boolean accountNonExpired, 
							   	boolean credentialsNonExpired,
							   	boolean accountNonLocked, 
							   	Collection<? extends GrantedAuthority> authorities) {
			
			super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		}
		
		private UserInfo userInfo;

		public UserInfo getUserInfo() {
			return userInfo;
		}

		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
		}
	}

}
