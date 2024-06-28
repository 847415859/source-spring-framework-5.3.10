package com.qiankun.schduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledJobs {

    private static final Logger log = LoggerFactory.getLogger(ScheduledJobs.class);

    //表示方法执行完成后5秒再开始执行
    @Scheduled(fixedDelay=5000)
    public void fixedDelayJob() throws InterruptedException{
        log.info("fixedDelay 开始:" + new Date());
        Thread.sleep(10 * 1000);
        log.info("fixedDelay 结束:" + new Date());
    }

    //表示每隔3秒
    @Scheduled(fixedRate=3000)
    public void fixedRateJob()throws InterruptedException{
        log.info("===========fixedRate 开始:" + new Date());
        Thread.sleep(5 * 1000);
        log.info("===========fixedRate 结束:" + new Date());
    }

    //表示每隔10秒执行一次
    @Scheduled(cron="0/10 * * * * ? ")
    public void cronJob(){
        log.info("=========================== ...>>cron...." + new Date());
    }
}