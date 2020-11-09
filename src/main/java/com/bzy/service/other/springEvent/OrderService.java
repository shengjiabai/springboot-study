package com.bzy.service.other.springEvent;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 模拟下单成功后发邮件 邮件通过spring事件监听机制实现
 * 
 * spring监听事件  只要定义一个事件  可以有多个监听者比如下面的短信服务、开车服务。。。 主要作用方便解耦
 * 
 * https://zhuanlan.zhihu.com/p/101128672
 */
@Service
public class OrderService {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    public void order(){
        //下单成功
        System.out.println("下单成功了");
        //短信服务 开车服务 
        applicationContext.publishEvent(new OrderSuccessEvent(this));
        
        System.out.println("主线程mian结束");
    }
}
