package com.jason.blog.domain.security.user;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.jason.blog.domain.security.authority.Authority;
import com.jason.blog.domain.security.role.Role;
import com.jason.blog.domain.shared.AbstractDomainObject;
import com.jason.blog.infrastruture.util.ConvertUtils;


@Entity
public class UserInfo extends AbstractDomainObject{
	private static final long serialVersionUID = 1L;

	private Set<Role> roles = new HashSet<Role>();

	private Map<String, String> roleMap = new HashMap<String, String>();

	@JsonIgnore
	public Set<Role> getRoles() {
		if (null == roles) {
			return Collections.emptySet();
		}
		return roles;
	}

	/**
	 * @return
	 */
	public String getRolesAsString() {
		return ConvertUtils.convertPropertyToString(getRoles(), "name", ",");
	}

	/**
	 * @return
	 */
	public Map<String, String> getRoleMap() {
		if (null == roleMap) {
			return Collections.emptyMap();
		}
		return roleMap;
	}

	public UserInfo setRoleMap(Map<String, String> roleMap) {
		this.roleMap = roleMap;
		return this;
	}

	public UserInfo fillupRoleMap() {
		Map<String, String> roleMap = new HashMap<String, String>();
		ConvertUtils.convertPropertyToMap(getRoles(), "id", "id", roleMap);
		return setRoleMap(roleMap);
	}

	public UserInfo setRoles(Set<Role> roles) {
		this.roles = roles;
		return this;
	}

	public Set<String> getAuthorityNames() {
		Set<String> authorityNames = new LinkedHashSet<String>();

		for (Role role : getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				authorityNames.add(authority.getName());
			}
		}

		return authorityNames;
	}

	public UserInfo encodePassword(PasswordEncoder encoder) {
		return setPassword(encoder.encodePassword(getPassword(), getUsername()));
	}
	@NotNull(message="用户名不能为空！") 
	@Size(min = 6, max = 20,message="用户名长度必须在6~20之间！")
	private String username;
	
	private String truename;
	
	private String password;

	@Pattern(regexp = "[0-9a-z\\-\\_A-Z]+@[0-9a-z\\-\\_A-Z]+\\.[a-z]{2,}",message="Email格式不正确！")
	private String email;
	
	private String phone;
	
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	public String getUsername() {
		return username;
	}

	public UserInfo setUsername(String userName) {
		this.username = userName;
		return this;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String trueName) {
		this.truename = trueName;
	}

	public String getPassword() {
		return password;
	}

	public UserInfo setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserInfo setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public UserInfo setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public UserInfo setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
		return this;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public UserInfo setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
		return this;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public UserInfo setEnabled(boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	public String getEnabledAsString() {
		return isEnabled() ? "正常" : "停用";
	}
}
