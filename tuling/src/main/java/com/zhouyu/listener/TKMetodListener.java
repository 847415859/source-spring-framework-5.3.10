package com.zhouyu.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date : 2023/03/30 7:45
 * @Auther : tiankun
 */
@Component
public class TKMetodListener {

    @EventListener
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof PayloadApplicationEvent){
            PayloadApplicationEvent<?> payloadApplicationEvent = (PayloadApplicationEvent<?>) event;
            System.out.println("payloadApplicationEvent.getPayload() = " + payloadApplicationEvent.getPayload());
        }
        System.out.println("接收到的事件为：{}" + event);
    }
}
