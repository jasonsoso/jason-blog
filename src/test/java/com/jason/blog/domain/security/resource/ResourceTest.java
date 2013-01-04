package com.jason.blog.domain.security.resource;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;

public class ResourceTest {
	/**
	 * 测试资源 entity  验证注解
	 */
	@Test
	public void testValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Resource resource = new Resource();
		resource.setName("");
		resource.setValue(null);
		Set<ConstraintViolation<Resource>> constraintViolations = validator
				.validate(resource);
		for (ConstraintViolation<Resource> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
			System.out.println(constraintViolation.getPropertyPath());
		}
		Assert.assertTrue(constraintViolations.size()>0);
	}

}
