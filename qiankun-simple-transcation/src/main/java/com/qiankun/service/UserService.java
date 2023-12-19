package com.qiankun.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Date : 2023/12/18 11:08
 * @Auther : tiankun
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Transactional
    public void m1(){
        jdbcTemplate.execute("insert into t_user values (1,'乾坤1',18,null)");
        // int i = 1/0;
        // jdbcTemplate.execute("insert into t_user values (2,'乾坤2',19,null)");
        UserService userService = (UserService) AopContext.currentProxy();
        userService.m2();
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void m2(){
        jdbcTemplate.execute("insert into t_user values (3,'乾坤3',20,null)");
    }
}
