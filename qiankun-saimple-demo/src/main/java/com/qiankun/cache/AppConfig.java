package com.qiankun.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Date : 2024/07/04 14:12
 * @Auther : tiankun
 */
@Configuration
@ComponentScan("com.qiankun.cache")
@EnableCaching  // 开启缓存
public class AppConfig {

    // 创建缓存管理器
    @Bean
    public ConcurrentMapCacheManager cacheManager() {
        ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
        //cacheManager.setStoreByValue(true); //true表示缓存一份副本，否则缓存引用
        return concurrentMapCacheManager;
    }
}
