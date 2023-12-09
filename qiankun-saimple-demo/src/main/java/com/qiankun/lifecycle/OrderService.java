package com.qiankun.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Date : 2023/12/08 17:49
 * @Auther : tiankun
 */
@Service
public class OrderService {

    @Autowired
    public User user;
}
