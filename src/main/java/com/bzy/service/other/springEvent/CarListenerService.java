package com.bzy.service.other.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 物流服务 监听OrderSuccessEvent
 */
@Service
public class CarListenerService implements ApplicationListener<OrderSuccessEvent> {
    @Override
    public void onApplicationEvent(OrderSuccessEvent event) {
        this.dispatch();
    }

    public void dispatch() {
        System.out.println("发车咯...");
    }
}