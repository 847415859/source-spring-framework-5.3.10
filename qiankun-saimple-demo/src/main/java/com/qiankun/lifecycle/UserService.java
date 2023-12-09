package com.qiankun.lifecycle;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Date : 2023/12/08 11:19
 * @Auther : tiankun
 */
@Service
public class UserService {

    @Autowired
    private User user;
    @Autowired
    private OrderService orderService;

    @PostConstruct
    public void init(){

    }

    @PreDestroy
    public void destory(){

    }
}
