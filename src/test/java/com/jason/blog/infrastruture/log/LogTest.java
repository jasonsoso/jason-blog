package com.jason.blog.infrastruture.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *	一直糾結 Log4j日志的問題:
 *	杜绝system.out 和system.err
 *	用这种形式logger.info("content is {} and privateKey is {}.",content,privateKey);
 *	不要用logger.info("content is "+content+" and privateKey is "+privateKey+".");
 *	logger.info 用于线上，记录重要的信息 
 *	logger.debug 用于开发，trycatch异常，比较常用
 *	logger.warn 用于是否稳定
 *	logger.error 用于系统错误，属于高级别
 * @author Jason
 *
 */
public class LogTest {
	private  Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 测试log日誌
	 */
	@Test
	public void testLog4j() {
		
		//用于线上，记录重要的信息  比如登录登出等
		logger.info("Hello!Jason");
		
		//用于开发，trycatch异常，比较常用
		logger.debug("Hello!Jason");  
        logger.debug("Hello {},Welcome to {}", "Jason", "China");
        Object[] paramArray = {"1", "2", "3"};  
        logger.debug("Value {} was inserted between {} and {}.", paramArray); 
        
        //WARN 为一般警告，用于是否稳定，比如session丢失
        logger.warn("我警告你！");
        
        //ERROR 为严重错误 主要是程序的错误
        //logger.error("空指針錯誤", new NullPointerException());
	}
}
