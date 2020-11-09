package com.bzy.service.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * SpringBoot提供了两个接口ApplicationRunner和CommandLineRunner，在容器启动成功之后，
 *  SpringApplication的run()方法完成之前回调，可以用来初始化一些数据，加载定时任务等
 *  spring 启动之后就会加载这类
 */
@Order(value = 1)
@Component //注入bean
public class CommandLineRunnerTest implements CommandLineRunner {

    /**
     *CommandLineRunner接受原始的参数，不做处理 
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("CommandLineRunner 开始执行了 Order=1");
    }
}
