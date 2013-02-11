package com.jason.blog.domain.security.user;

import java.util.List;
import java.util.Map;

import com.jason.blog.infrastruture.persist.hibernate.query.Page;

public interface UserInfoRepository {
	UserInfo queryByName(String username);

	Page<UserInfo> queryPage(Page<UserInfo> page, String hql, Map<String, Object> values);

	List<UserInfo> query(String queryString, Object... values);

	UserInfo get(Long id);

	void store(UserInfo entity);

	void delete(Long id);
	
	void updatePhoto(String photo, UserInfo user) ;
}
