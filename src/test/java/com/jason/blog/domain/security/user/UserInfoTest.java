package com.jason.blog.domain.security.user;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class UserInfoTest {
	/**
	 * 测试用户 entity  验证注解
	 */
	@Test
	public void testValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		UserInfo user = new UserInfo();
		user.setUsername(null);
		Set<ConstraintViolation<UserInfo>> constraintViolations = validator
				.validate(user);
		for (ConstraintViolation<UserInfo> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
			System.out.println(constraintViolation.getPropertyPath());
		}
		Assert.assertTrue(constraintViolations.size()>0);
	}
	/**
	 * 根据用户名和密码 生成加密密码
	 */
	@Test
	public void testEncodePassword(){
		UserInfo user = new UserInfo()
			.setUsername("admin123")
			.setPassword("admin123");
		
		user.encodePassword(new Md5PasswordEncoder());
		System.out.println(user.getPassword());
	}

}
