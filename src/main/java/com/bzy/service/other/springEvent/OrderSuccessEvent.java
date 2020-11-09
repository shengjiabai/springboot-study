package com.bzy.service.other.springEvent;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
public class OrderSuccessEvent extends ApplicationEvent {
    
    public OrderSuccessEvent(Object source) {
        super(source);
    }
}
