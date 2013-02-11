package com.jason.blog.infrastruture.util;

import org.junit.Assert;
import org.junit.Test;

public class CommandLineHelperTest {
	
	@Test
	public void testOS() throws Exception {
		String os = CommandLineHelper.getOS();
		
		Assert.assertNotNull(os);
	}
	@Test
	public void testExec() throws Exception {
		boolean result = CommandLineHelper.Exec("pwd");
		Assert.assertTrue(result);
	}
	
}
