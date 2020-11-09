package com.bzy.service.other.springEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ZhujieSmsLenerService {

    /**
     * 发送短信 @EventListener指定监听的事件
     */
    @EventListener(OrderSuccessEvent.class)
    public void sendSms1() {
//
//        try {
//            Thread.sleep(1000L * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("注解实现发送短信...");
    }
}
