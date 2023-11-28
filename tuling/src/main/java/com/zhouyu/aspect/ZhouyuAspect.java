package com.zhouyu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ZhouyuAspect {

	@Pointcut("execution(public void com.zhouyu.service.UserService.test())")
	public void a(){

	}

	@Before("a()")
	public void zhouyuBefore(JoinPoint joinPoint) {
		System.out.println("zhouyuBefore");
		System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());
	}
}
