package com.zhouyu;

import com.zhouyu.service.UserInterface;
import com.zhouyu.service.UserService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Date : 2023/04/01 7:32
 * @Auther : tiankun
 */
public class TestProxy {
    public static void main(String[] args) {
        UserService target = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        // proxyFactory.setTargetClass(UserInterface.class);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("执行前...");
                // method.invoke(target,args);
                // System.out.println("执行后...");
            }
        });
        UserService userProxy = (UserService) proxyFactory.getProxy();
        // userProxy.test();
    }
}
