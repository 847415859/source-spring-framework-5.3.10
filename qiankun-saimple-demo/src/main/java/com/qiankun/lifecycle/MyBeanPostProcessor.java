package com.qiankun.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2023/12/08 11:19
 * @Auther : tiankun
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization : "+ beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization : "+ beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
