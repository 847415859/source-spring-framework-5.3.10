package com.qiankun.proxy;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Date : 2023/12/15 13:51
 * @Auther : tiankun
 */
@Service
public class UserInterfaceImpl implements UserInterface{
    @Override
    public void exec() {
        System.out.println("UserInterfaceImpl#exec");
    }
}
