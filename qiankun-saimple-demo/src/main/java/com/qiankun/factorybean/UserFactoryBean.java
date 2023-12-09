package com.qiankun.factorybean;

import com.qiankun.po.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Description: SmartFactoryBean 实现 FactoryBean 接口，主要提供了 isEagerInit 方法，用于是否提前初始化
 * @Date : 2023/12/07 8:11
 * @Auther : tiankun
 */
@Component
public class UserFactoryBean implements SmartFactoryBean<User> {

    /**
     * 是否提前初始化（如果为true，则会在Spring容器启动的步骤【初始化所有的非单例Bean进行创建】）
     * 否则是在获取Bean的在进行创建
     * @return
     */
    @Override
    public boolean isEagerInit() {
        return false;
    }

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
