package com.qiankun.proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2023/12/15 13:55
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        Class<? extends UserService> clazz = userService.getClass();
        System.out.println(clazz);
        for (Class<?> interfaceClass : clazz.getInterfaces()) {
            System.out.println("InterfaceClass = " + interfaceClass.getName());
        }
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("SuperClass = " + superclass.getName());

        UserInterface userInterface = (UserInterface) userService;
        userInterface.exec();
    }
}
