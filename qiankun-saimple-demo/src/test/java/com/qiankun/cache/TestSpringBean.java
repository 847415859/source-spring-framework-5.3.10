package com.qiankun.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Date : 2024/07/04 14:13
 * @Auther : tiankun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestSpringBean {

    @Autowired
    private CacheDemoService cacheDemoService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test(){
        cacheDemoService.getFromDb(1L);
        cacheDemoService.getFromDb(1L);

        // 校验缓存里的内容
        Cache demoCache = cacheManager.getCache("demoCache");
        System.out.println(demoCache.getName());
        System.out.println(demoCache.get(1L, String.class));
    }
}
