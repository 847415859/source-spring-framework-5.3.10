package com.qiankun.importer;

import com.qiankun.service.UserService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Date : 2023/03/31 9:47
 * @Auther : tiankun
 */
public class MyImport implements ImportBeanDefinitionRegistrar {
    // 可以获取到 BeanFactory 我们自己加入 BeanDefinition
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry, importBeanNameGenerator);
        GenericBeanDefinition importBeanDefinition = new GenericBeanDefinition();
        importBeanDefinition.setBeanClass(UserService.class);
        registry.registerBeanDefinition("importUserService", importBeanDefinition);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
    }
}
