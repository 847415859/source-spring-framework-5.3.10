package com.qiankun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	// @Pointcut("execution(public void com.qiankun.service.UserService.test())")
	public void a(){

	}

	// @Before("a()")
	public void zhouyuBefore(JoinPoint joinPoint) {
		System.out.println("zhouyuBefore");
		System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());
	}
}
