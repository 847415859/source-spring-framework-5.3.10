package com.qiankun.lifecycle;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2023/12/08 11:44
 * @Auther : tiankun
 */
@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        System.out.println("MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition "+ beanName);
    }

    @Override
    public void resetBeanDefinition(String beanName) {
        System.out.println("MergedBeanDefinitionPostProcessor.resetBeanDefinition "+ beanName);
        MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
    }
}
