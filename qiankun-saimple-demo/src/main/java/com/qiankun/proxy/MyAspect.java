package com.qiankun.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2023/12/15 13:53
 * @Auther : tiankun
 */
@Component
@Aspect
public class MyAspect {

    @DeclareParents(value = "com.qiankun.proxy.UserService",defaultImpl = UserInterfaceImpl.class)
    public UserInterface userInterface;

}
