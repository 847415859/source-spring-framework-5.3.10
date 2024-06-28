package com.qiankun.spel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2024/06/27 12:25
 * @Auther : tiankun
 */
@Component
@Slf4j
public class SchduleExector {

    @Scheduled(cron = "0/5 * * * * ?", zone = "Asia/Shanghai")
    public void execute() {
        System.out.println(System.currentTimeMillis() / 1000 + "执行定时任务");
    }
}
