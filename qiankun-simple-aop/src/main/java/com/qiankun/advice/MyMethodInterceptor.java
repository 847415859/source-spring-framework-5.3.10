package com.qiankun.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Date : 2023/12/15 16:41
 * @Auther : tiankun
 */
@Component
public class MyMethodInterceptor implements MethodInterceptor {
    @Nullable
    @Override
    public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
        System.out.println("MyMethodInterceptor#bofore");
        Object result = invocation.proceed();
        System.out.println("MyMethodInterceptor#after");
        return result;
    }
}
