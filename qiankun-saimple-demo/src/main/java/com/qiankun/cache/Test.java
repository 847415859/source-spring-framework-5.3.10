package com.qiankun.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2024/07/04 14:23
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CacheDemoService cacheDemoService = applicationContext.getBean(CacheDemoService.class);
        cacheDemoService.getFromDb(1L);
        cacheDemoService.getFromDb(1L);
        CacheManager cacheManager = applicationContext.getBean(CacheManager.class);
        // 校验缓存里的内容
        Cache demoCache = cacheManager.getCache("demoCache");
        System.out.println(demoCache.getName());
        System.out.println(demoCache.get(1L, String.class));
    }
}
