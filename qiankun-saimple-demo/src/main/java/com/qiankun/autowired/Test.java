package com.qiankun.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2023/12/09 10:12
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Test.class.getPackage().getName());
        UserService bean = applicationContext.getBean(UserService.class);
        System.out.println(bean);
    }
}
