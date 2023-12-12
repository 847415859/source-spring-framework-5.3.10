package com.qiankun.autowired;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Date : 2023/12/11 17:35
 * @Auther : tiankun
 */
public class BaseService <O,S>{

    @Autowired
    protected O o;

    @Autowired
    protected S s;
}
