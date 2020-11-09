package com.bzy.service.other.celuemoshi;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  ContextRefreshedEvent	当容器被实例化或refreshed时发布.如调用refresh()方法,
 *  此处的实例化是指所有的bean都已被加载,后置处理器都被激活,所有单例bean都已被实例化, 
 *  所有的容器对象都已准备好可使用. 如果容器支持热重载,则refresh可以被触发多次(XmlWebApplicatonContext支持热刷新,而GenericApplicationContext则不支持)
 */
@Component
public class MessageServiceListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("统计bean的数据="+event.getApplicationContext().getBeanDefinitionCount());
                
        //获得所有使用了MsgTypeHandler注解的beta
        Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(MsgTypeHandler.class);
        //获取MessageServiceContext bean
        MessageServiceContext messageServiceContext = event.getApplicationContext().getBean(MessageServiceContext.class);
        beans.forEach((name, bean) -> {
            MsgTypeHandler typeHandler = bean.getClass().getAnnotation(MsgTypeHandler.class);
            messageServiceContext.putMessageService(typeHandler.value().code, (MessageService) bean);
        });
    }
}