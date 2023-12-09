package com.qiankun.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2023/12/07 9:11
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.qiankun.service");
    }
}
