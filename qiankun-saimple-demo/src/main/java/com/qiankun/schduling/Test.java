package com.qiankun.schduling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Date : 2024/06/27 14:49
 * @Auther : tiankun
 */
public class Test {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SyncTask syncTask = applicationContext.getBean(SyncTask.class);
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}
