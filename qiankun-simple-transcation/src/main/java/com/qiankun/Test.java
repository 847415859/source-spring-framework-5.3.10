package com.qiankun;

import com.qiankun.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description:
 * @Date : 2023/12/18 8:53
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.m1();

    }
}
