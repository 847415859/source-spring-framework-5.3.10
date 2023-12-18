package com.qiankun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2023/12/15 17:51
 * @Auther : tiankun
 */
@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(public void com.qiankun.service.UserService.exec())")
    public void a(){

    }

    @Before("a()")
    public void before(JoinPoint joinPoint) {
        System.out.println("MyAspect#before");
        System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());
    }

    @After("a()")
    public void after(JoinPoint joinPoint){
        System.out.println("MyAspect#after");
    }


    @Around("a()")
    public Object around(ProceedingJoinPoint pjp){
        Object proceed = null;
        try {
            System.out.println("MyAspect#around#before");
            proceed = pjp.proceed();
            System.out.println("MyAspect#around#after");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("MyAspect#around#error");
        }
        return proceed;
    }

    @AfterReturning("a()")
    public void afterReturning(){
        System.out.println("MyAspect#afterReturning");
    }
}
