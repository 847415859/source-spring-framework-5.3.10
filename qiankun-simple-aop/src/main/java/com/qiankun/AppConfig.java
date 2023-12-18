package com.qiankun;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:
 * @Date : 2023/12/15 13:55
 * @Auther : tiankun
 */
@Configuration
@ComponentScan(basePackages = {"com.qiankun"})
@EnableAspectJAutoProxy
public class AppConfig {
}
