package com.qiankun.advice;


import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Date : 2023/12/15 16:35
 * @Auther : tiankun
 */
@Component
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, NullPointerException ex) {
        System.out.println("方法抛出异常后执行");
    }
}
