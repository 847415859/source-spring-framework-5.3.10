package com.qiankun.spel;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Date : 2024/06/26 17:10
 * @Auther : tiankun
 */
@Component
public class OrderService {

    @Resource(name = "${beanName}")
    public UserService userService;
}
