package com.bzy.service.other.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 短信服务，监听OrderSuccessEvent
 */
@Service
public class SmsListenerService implements ApplicationListener<OrderSuccessEvent> {
    
    @Override
    public void onApplicationEvent(OrderSuccessEvent orderSuccessEvent) {
        this.sendSms();
    }

    /**
     * 发送短信
     */
    public void sendSms() {
        System.out.println("发送短信...");
    }


  
}
