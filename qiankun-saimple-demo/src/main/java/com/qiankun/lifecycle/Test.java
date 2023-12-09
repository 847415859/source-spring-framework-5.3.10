package com.qiankun.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2023/12/08 11:18
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.qiankun.lifecycle");
        applicationContext.close();
    }
}
