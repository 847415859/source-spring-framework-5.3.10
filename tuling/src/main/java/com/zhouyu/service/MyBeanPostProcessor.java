package com.zhouyu.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2023/03/27 15:21
 * @Auther : tiankun
 */
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, MergedBeanDefinitionPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        // System.out.println("===========> " +beanName);
        if("userService".equals(beanName)) {
            // OrderService orderService = new OrderService();
            // System.out.println("MyBeanPostProcessor orderService: " + orderService);
            // beanDefinition.getPropertyValues().addPropertyValue("orderService",orderService);
        }
        // beanDefinition.getPropertyValues().add("orderService", orderService);
    }
}
