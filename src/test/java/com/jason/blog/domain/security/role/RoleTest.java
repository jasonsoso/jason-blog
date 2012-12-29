package com.jason.blog.domain.security.role;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

public class RoleTest {

	/**
	 * 测试角色entity 验证注解
	 */
	@Test
	public void testValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Role role = new Role();
		role.setName(null);
		Set<ConstraintViolation<Role>> constraintViolations = validator.validate(role);
		for (ConstraintViolation<Role> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
			System.out.println(constraintViolation.getPropertyPath());
		}
		
	}
	
}
