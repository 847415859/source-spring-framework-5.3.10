package com.qiankun.advisor;

import com.qiankun.advice.MyBeforeAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Date : 2023/12/15 16:42
 * @Auther : tiankun
 */
@Component
public class MyPointcutAdvisor implements PointcutAdvisor {

    @Override
    public Advice getAdvice() {
        return new MyBeforeAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                System.out.println("MyPointcutAdvisor#getPointcut#getClassFilter");
                // 类匹配器
                return new ClassFilter() {
                    @Override
                    public boolean matches(Class<?> clazz) {
                        return Boolean.TRUE;
                    }
                };
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                System.out.println("MyPointcutAdvisor#getPointcut#getMethodMatcher");
                // 方法匹配器
                return new MethodMatcher() {
                    // 校验时使用
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return Boolean.TRUE;
                    }

                    // 上面无参数的匹配器只是在匹配是否有资格代理拦截，但不一定真正的会处理
                    // 如果 isRuntime为true,则说明在执行时还需要校验下面有参的匹配器。判断入参是否也一样
                    // 如果为false,则不在校验
                    @Override
                    public boolean isRuntime() {
                        return true;
                    }

                    // 运行时使用 isRuntime() = true 才会调用
                    @Override
                    public boolean matches(Method method, Class<?> targetClass, Object... args) {
                        return Boolean.TRUE;
                    }
                };
            }
        };
    }
}
