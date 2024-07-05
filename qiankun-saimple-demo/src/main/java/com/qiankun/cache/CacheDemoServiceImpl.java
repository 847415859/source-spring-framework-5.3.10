package com.qiankun.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Date : 2024/07/04 14:11
 * @Auther : tiankun
 */
@Service
public class CacheDemoServiceImpl implements CacheDemoService {

    @Cacheable(cacheNames = "demoCache", key = "#id")
    @Override
    public Object getFromDb(Long id) {
        System.out.println("模拟db查询返回结果...");
        return "spring cache";
    }
}
