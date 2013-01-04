package com.jason.blog.domain.security.user;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;

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

}
