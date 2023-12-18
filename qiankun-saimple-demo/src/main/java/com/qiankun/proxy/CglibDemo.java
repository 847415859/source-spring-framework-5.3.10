package com.qiankun.proxy;

import org.springframework.cglib.core.ClassLoaderAwareGeneratorStrategy;
import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description:
 * @Date : 2023/12/15 9:08
 * @Auther : tiankun
 */
public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("proxy = " + proxy.getClass());
                System.out.println("method = " + method);
                System.out.println("args = " + Arrays.toString(args));
                System.out.println("methodProxy = " + methodProxy);
                return methodProxy.invokeSuper(proxy,args);
            }
        });



        UserService userService = (UserService) enhancer.create();
        userService.test();


    }
}
