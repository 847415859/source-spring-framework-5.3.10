package com.zhouyu.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class UserService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserService userService;


    // @Autowired
    // private OrderService orderService;

    @Lookup
    public OrderService getOrderService() {
        // return applicationContext.getBean("orderService",OrderService.class);
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    // @Transactional(rollbackForClassName = {},rollbackFor = {},noRollbackFor = {},noRollbackForClassName = {})
    // public void a(){
    //     jdbcTemplate.execute("INSERT INTO `test`.`t_user`(`id`, `name`, `age`) VALUES (1, '田坤1', 18);");
    //     try {
    //         userService.b();
    //     } catch (Exception e) {
    //     }
    // }
    //
    // @Transactional
    // public void b(){
    //     jdbcTemplate.execute("INSERT INTO `test`.`t_user`(`id`, `name`, `age`) VALUES (2, '田坤2', 18);");
    //     throw new NullPointerException();
    // }
}
