package com.barath.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Aspect
public class SwaggerAspect {
	
	
	@Pointcut(value="execution(* springfox.documentation.swagger2.web.Swagger2Controller.*(..))")
	public void getSwaggerDocs(){
		
	}
	
	@Before("getSwaggerDocs()")
	public void handleBeforeCall(){
		System.out.println("Before getting swagger docs is called");
	}
	
	@After("getSwaggerDocs()")
	public void handleAfterCall(JoinPoint joinPoint){
		System.out.println("After getting swagger docs is called");
	}

}
