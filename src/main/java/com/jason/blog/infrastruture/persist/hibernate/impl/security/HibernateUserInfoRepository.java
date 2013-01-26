package com.jason.blog.infrastruture.persist.hibernate.impl.security;

import org.springframework.stereotype.Repository;

import com.jason.blog.domain.security.user.UserInfo;
import com.jason.blog.domain.security.user.UserInfoRepository;
import com.jason.blog.infrastruture.persist.hibernate.HibernateRepositorySupport;

@Repository
public class HibernateUserInfoRepository extends HibernateRepositorySupport<Long, UserInfo> implements UserInfoRepository {

	@Override
	public UserInfo queryByName(String username) {
		return (UserInfo) super.queryUnique("from UserInfo where username=?", username);
	}

	@Override
	public void delete(Long id) {
		super.delete(super.get(id));
	}

}
