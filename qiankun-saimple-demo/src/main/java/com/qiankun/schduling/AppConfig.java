package com.qiankun.schduling;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description:
 * @Date : 2024/06/27 14:49
 * @Auther : tiankun
 */
@Configuration
@ComponentScan(basePackages = "com.qiankun.schduling")
@EnableScheduling
public class AppConfig {
}
