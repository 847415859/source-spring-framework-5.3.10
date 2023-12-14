package com.qiankun.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2023/12/09 10:12
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        // 这样初始化不会主动调用 refresh方法
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.getEnvironment().setRequiredProperties("global.config.path");
        applicationContext.refresh();
        OrderService bean = applicationContext.getBean(OrderService.class);
        System.out.println(bean);
    }
}
