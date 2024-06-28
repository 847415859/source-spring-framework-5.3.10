package com.qiankun.proxy;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2023/12/15 13:53
 * @Auther : tiankun
 */
@Component
@Aspect
public class MyAspect {

    // @DeclareParents(value = "com.qiankun.proxy.UserService",defaultImpl = UserInterfaceImpl.class)
    // public UserInterface userInterface;

    @Pointcut("execution(* com.qiankun.proxy.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }


    @After("pointcut()")
    public void after(){
        System.out.println("after");
    }

}
