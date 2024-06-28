package com.qiankun.schduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SyncTask extends AbstractTask {
    @Override
    @MyAsync
    public void doTaskOne() throws Exception {
        super.doTaskOne();
    }

    @Override
    @MyAsync
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }

    @Override
    @MyAsync
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}