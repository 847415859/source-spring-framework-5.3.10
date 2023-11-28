package com.zhouyu;

import com.zhouyu.service.OrderService;
import com.zhouyu.service.User;
import com.zhouyu.service.UserService;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {

		// 创建一个Spring容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// OrderService orderService1 = applicationContext.getBean("orderService", OrderService.class);
		// OrderService orderService2 = applicationContext.getBean("orderService", OrderService.class);
		// OrderService orderService3 = applicationContext.getBean("orderService", OrderService.class);
		UserService userService = applicationContext.getBean("userService", UserService.class);
		OrderService orderService1 = userService.getOrderService();
		OrderService orderService2 = userService.getOrderService();
		OrderService orderService3 = userService.getOrderService();
		System.out.println("orderService1 = " + orderService1);
		System.out.println("orderService2 = " + orderService2);
		System.out.println("orderService3 = " + orderService3);
		applicationContext.close();


		// applicationContext.publishEvent("发布事件");
		// applicationContext.publishEvent(new ApplicationEvent("发布事件2") {
		// 	@Override
		// 	public Object getSource() {
		// 		return super.getSource();
		// 	}
		// });

		// applicationContext.registerShutdownHook();
		// applicationContext.close();
		//
		// Runtime.getRuntime().addShutdownHook(new Thread(() -> {
		// 	System.out.println("自定义虚拟机退出执行时间");
		// }));


//		UserService userService1 = new UserService();
//
//		for (Field field : userService1.getClass().getDeclaredFields()) {
//			if (field.isAnnotationPresent(Autowired.class)) {
//				field.set(userService1, ??);
//			}
//		}
//
//
//		for (Method method : userService1.getClass().getDeclaredMethods()) {
//			if (method.isAnnotationPresent(PostConstruct.class)) {
//				method.invoke(userService1, null);
//			}
//		}
//
//		if (userService1 instanceof InitializingBean) {
//			try {
//				((InitializingBean)userService1).afterPropertiesSet();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		ProxyFactory proxyFactory = new ProxyFactory();
//		proxyFactory.setTarget(userService1);
//		proxyFactory.addAdvice(new MethodInterceptor() {
//			@Nullable
//			@Override
//			public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
//				System.out.println("切面逻辑 before...");
//				Object result = invocation.proceed();
////				Object result = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
//				System.out.println("切面逻辑 after...");
//				return result;
//			}
//		});
//		UserService userService2  = (UserService) proxyFactory.getProxy();
//		userService2.test();

	}


	public static void test(){
		Scanner scanner = new Scanner(System.in);
		int nextInt = scanner.nextInt();
		int i = 0;
		int count = 0;
		while (i <= nextInt){
			if(i % 3 == 0){
				System.out.print(i+"\t");
				count++;
			}
			if(count % 5 == 0 && count != 0){
				count = 0;
				System.out.print("\n");
			}
			i++;
		}
	}
}







