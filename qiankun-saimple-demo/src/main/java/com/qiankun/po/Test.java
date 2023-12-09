package com.qiankun.po;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2023/12/07 13:42
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.qiankun.po");
        System.out.println(applicationContext.getBean("user"));

    }
}
