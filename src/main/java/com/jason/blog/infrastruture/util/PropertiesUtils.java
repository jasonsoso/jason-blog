package com.jason.blog.infrastruture.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jason
 * @date 2013-2-11 下午07:45:45
 */
public class PropertiesUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
	
	/**
	 * 缓存配置文件
	 * String:配置文件路径
	 * Properties:java.util.Properties
	 */
	private static Map<String,Properties> propMap = new HashMap<String,Properties>();

	
	/**
	 * 根据properties的属性文件路径 读取生成java.util.Properties对象
	 * @param propName 属性文件名 properties格式 默认文件名:META-INF/config/framework.properties
	 * @return java.util.Properties
	 */
	public static Properties getProperties(String propName) {
		if (propName == null){
			propName = "META-INF/config/framework.properties";
		}
		if (propMap.containsKey(propName)){//判断是否包含key[propName]，有则直接返回 ，否则读取
			return (Properties) propMap.get(propName);
		}
		Properties props = new Properties();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream(propName));
			propMap.put(propName, props);
		} catch (Exception e) {
			logger.error("getProperties(String) error",e);
		}
		return props;
	}

	/**
	 * @param propName
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getEntryValue(String propName, String key, String defaultValue) {
		Properties prop = getProperties(propName);
		if (prop != null) {
			return prop.getProperty(key, defaultValue);
		}
		return null;
	}

	/**
	 * 根据key值获取属性值
	 * @param propName  属性文件名
	 * @param key 
	 * @return 属性值
	 */
	public static String getEntryValue(String propName, String key) {
		Properties prop = getProperties(propName);
		if (prop != null) {
			return prop.getProperty(key);
		}
		return null;
	}

	/**
	 * @param key
	 * @return
	 */
	public static String getEntryValue(String key) {
		return getEntryValue(null, key);
	}

	/**
	 * @param key
	 * @return
	 */
	public static int getIntEntryValue(String key) {
		String value = getEntryValue(null, key);
		int intValue = 0;
		if (value != null) {
			try {
				intValue = Integer.parseInt(value.trim());
			} catch (NumberFormatException ex) {
			}
		}
		return intValue;
	}

	/**
	 * @param key
	 * @return
	 */
	public static long getLongEntryValue(String key) {
		String value = getEntryValue(null, key);
		long longValue = 0;
		if (value != null) {
			try {
				longValue = Long.parseLong(value.trim());
			} catch (NumberFormatException ex) {
			}
		}
		return longValue;
	}
}
