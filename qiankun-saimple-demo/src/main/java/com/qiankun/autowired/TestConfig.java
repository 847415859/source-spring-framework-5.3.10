package com.qiankun.autowired;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Date : 2023/12/09 10:14
 * @Auther : tiankun
 */
@Configuration
public class TestConfig {

    // @Bean(autowire = Autowire.BY_TYPE)
    public UserService userService(){
        return new UserService();
    }
}
