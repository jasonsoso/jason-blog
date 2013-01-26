package com.jason.blog.application.security.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jason.blog.application.security.UserInfoService;
import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.domain.security.user.UserInfoRepository;
import com.jason.blog.infrastruture.persist.hibernate.query.Page;

@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	
	private UserInfoRepository userInfoRepository;

	@Autowired
	public void setUserInfoRepository(UserInfoRepository userInfoRepository) {
		this.userInfoRepository = userInfoRepository;
	}

	@Override
	public void delete(Long id) {
		userInfoRepository.delete(id);
	}

	@Override
	public void store(UserInfo entity) {
		userInfoRepository.store(entity);
	}

	@Override
	public UserInfo get(Long id) {
		return userInfoRepository.get(id);
	}

	@Override
	public List<UserInfo> query(String queryString, Object... values) {
		return userInfoRepository.query(queryString, values);
	}

	@Override
	public Page<UserInfo> queryPage(Page<UserInfo> page, String hql, Map<String, Object> values) {
		return userInfoRepository.queryPage(page, hql, values);
	}

}
