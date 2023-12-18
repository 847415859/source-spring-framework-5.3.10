package com.qiankun.proxyfactory;

import com.qiankun.advice.*;
import com.qiankun.advisor.MyPointcutAdvisor;
import com.qiankun.service.UserInterface;
import com.qiankun.service.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Date : 2023/12/15 10:41
 * @Auther : tiankun
 */
public class ProxyFactoryDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        UserService userService = new UserService();
        proxyFactory.setTarget(userService);
        proxyFactory.setInterfaces(UserInterface.class);
        // 添加一个切面（切入点 + 通知）
        proxyFactory.addAdvice(new MyBeforeAdvice());
        proxyFactory.addAdvice(new MyAfterReturningAdvice());
        proxyFactory.addAdvice(new MyThrowsAdvice());
        proxyFactory.addAdvice(new MyMethodInterceptor());

        proxyFactory.addAdvisor(new MyPointcutAdvisor());
        // proxyFactory.addAdvisor(new PointcutAdvisor() {
        //     @Override
        //     public Pointcut getPointcut() {
        //         return new StaticMethodMatcherPointcut() {
        //             // 如果方法名为 test 才进行拦截
        //             @Override
        //             public boolean matches(Method method, Class<?> targetClass) {
        //                 return "test".equals(method.getName());
        //             }
        //         };
        //     }
        //
        //     @Override
        //     public Advice getAdvice() {
        //         // 前置通知
        //         return new MethodBeforeAdvice() {
        //             @Override
        //             public void before(Method method, Object[] args, Object target) throws Throwable {
        //                 System.out.println("PointcutAdvisor#Before");
        //             }
        //         };
        //     }
        //
        //     @Override
        //     public boolean isPerInstance() {
        //         return false;
        //     }
        // });
        UserInterface proxy = (UserInterface) proxyFactory.getProxy();
        System.out.println(proxy);
        proxy.exec();
    }
}
