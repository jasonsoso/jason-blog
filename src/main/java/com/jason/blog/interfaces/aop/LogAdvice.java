package com.jason.blog.interfaces.aop;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.jason.blog.infrastruture.annotation.Auditable;

@Aspect
@Component
public class LogAdvice {
	//@Autowired 
	
	//定義一個切入點，在方法含有@Auditable注解的位置切入
    
	//@Around(value = "@annotation(auditable)")
	@AfterReturning(value="@annotation(auditable)")
	public void after(JoinPoint joinpoint,Auditable auditable) throws Throwable {
		System.out.println("start...");
		//Date date = new Date(System.currentTimeMillis());
    	System.out.println(joinpoint.toString());
    	System.out.println(joinpoint.getThis());
    	System.out.println(joinpoint.getTarget());//拦截的实体类
    	System.out.println(joinpoint.getArgs());//拦截的方法参数
    	//Object[] object = joinpoint.getArgs();
    	//for (int i = 0; i < object.length; i++) {
		//}
    	//获取方法名  
        String methodName = joinpoint.getSignature().getName();  
        //获取操作内容  
        String opContent = adminOptionContent(joinpoint.getArgs(), methodName);  
        System.out.println(opContent);
    	System.out.println(joinpoint.getSignature().getName());//拦截的方法名称
    	
    	System.out.println(joinpoint.getSourceLocation());
    	
		System.out.println(auditable.action());
		
		System.out.println(joinpoint.getTarget().getClass().getName());
		System.out.println(joinpoint.getSignature().getName());
		System.out.println(joinpoint.getArgs().toString());
		
		System.out.println("end...");
	}
    
    /** 
     * 使用Java反射来获取被拦截方法(insert、update)的参数值， 
     * 将参数值拼接为操作内容 
     */  
    public String adminOptionContent(Object[] args, String mName){  
        if (args == null) {  
            return null;  
        }  
        StringBuffer rs = new StringBuffer();  
        rs.append(mName);  
        String className = null;  
        int index = 1;  
        // 遍历参数对象  
        for (Object info : args) {  
            //获取对象类型  
            className = info.getClass().getName();  
            className = className.substring(className.lastIndexOf(".") + 1);  
            rs.append("[参数" + index + "，类型：" + className + "，值：");  
            // 获取对象的所有方法  
            Method[] methods = info.getClass().getDeclaredMethods();  
            // 遍历方法，判断get方法  
            for (Method method : methods) {  
                String methodName = method.getName();  
                // 判断是不是get方法  
                if (methodName.indexOf("get") == -1) {// 不是get方法  
                    continue;// 不处理  
                }  
                Object rsValue = null;  
                try {  
                    // 调用get方法，获取返回值  
                    rsValue = method.invoke(info);  
                    if (rsValue == null) {//没有返回值  
                        continue;  
                    }  
                } catch (Exception e) {  
                    continue;  
                }  
                //将值加入内容中  
                rs.append("(" + methodName + " : " + rsValue + ")");  
            }  
            rs.append("]");  
            index++;  
        }  
        return rs.toString();  
    }  

}
