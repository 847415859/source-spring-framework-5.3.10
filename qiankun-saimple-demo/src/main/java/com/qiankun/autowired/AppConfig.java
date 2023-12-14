package com.qiankun.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description:
 * @Date : 2023/12/13 11:51
 * @Auther : tiankun
 */
@Configuration(proxyBeanMethods = true)
// @ComponentScan("com.qiankun.autowired")
// @ImportResource(locations = {"spring.xml"})
public class AppConfig {

    @Bean
    public UserService userService() {
        System.out.println(orderService());
        System.out.println(orderService());
        return new UserService();
    }


    @Bean
    public OrderService orderService() {
        return new OrderService();
    }
}
