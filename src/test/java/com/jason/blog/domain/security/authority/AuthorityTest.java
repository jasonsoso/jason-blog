package com.jason.blog.domain.security.authority;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;

public class AuthorityTest {

	/**
	 * 测试权限entity 验证注解
	 */
	@Test
	public void testValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Authority authority = new Authority();
		authority.setName("");
		Set<ConstraintViolation<Authority>> constraintViolations = validator.validate(authority);
		for (ConstraintViolation<Authority> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
			System.out.println(constraintViolation.getPropertyPath());
		}
		Assert.assertTrue(constraintViolations.size()>0);
		
	}
	
}
