package com.jason.blog.infrastruture.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * Spring Bean Holder
 * @author Jason
 *
 */
@Component
public class SpringBeanHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.
	 * ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringBeanHolder.applicationContext = applicationContext;
	}

	/**
	 * 
	 * @param <T>
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		Object bean = applicationContext.getBean(clazz);

		if (null != bean && !clazz.isAssignableFrom(clazz)) {
			throw new UnsupportedOperationException(String.format("There are more than one bean that %s represent!", clazz.getName()));
		}
		return (T) bean;
	}

	private static void checkApplicationContext() {
		if (null == applicationContext) {
			throw new UnsupportedOperationException("applicationContext is null,you must define it in SpringIoc");
		}
	}

}
