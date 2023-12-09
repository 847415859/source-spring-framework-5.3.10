package com.qiankun.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserService userService;


    @Autowired
    private OrderService orderService;

    @Lookup(value = "orderService")
    public OrderService getOrderService() {
        // return applicationContext.getBean("orderService",OrderService.class);
        return orderService;
    }

    public void test(){
        System.out.println(orderService);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Transactional(rollbackForClassName = {},rollbackFor = {},noRollbackFor = {},noRollbackForClassName = {})
    public void a(){
        jdbcTemplate.execute("INSERT INTO `test`.`t_user`(`id`, `user_name`, `age`) VALUES (1, '田坤1', 18);");
        try {
            userService.b();
        } catch (Exception e) {

        }
    }

    @Transactional(propagation = Propagation.NEVER)
    public void b(){
        jdbcTemplate.execute("INSERT INTO `test`.`t_user`(`id`, `user_name`, `age`) VALUES (2, '田坤2', 18);");
        throw new NullPointerException();
    }
}
