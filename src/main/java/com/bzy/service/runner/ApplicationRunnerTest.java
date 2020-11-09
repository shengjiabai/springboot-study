package com.bzy.service.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 当初始化工作比较多的时候，我们可能会创建多个类来实现 ApplicationRunner 接口，
 * 这时候我们可以通过 @Order 注解来决定执行的先后顺序，值越小越先执行
 */
@Order(value = 2)
@Component
public class ApplicationRunnerTest implements ApplicationRunner {

    /**
     * ApplicationRunner则对原始参数做了封装，可以接收key/value形式的参数
     * ApplicationRunner的参数分为可选项参数（Optional Arguments）和非可选项参数（Non-Optional Arguments），前者指可key/value型参数，后者指不是key/value型参数。
     * 可以java -jar 启动时指定的参数 --name=lisi  --server.port=8080
     * ApplicationArguments五个参数：
     * getSourceArgs()	获取参数源
     * getOptionNames()	获取所有参数名称
     * containsOption(String name)	判断是否包含指定名称的参数
     * getOptionValues(String name)	根据参数名称来获取指定参数
     * getNonOptionArgs()	获取所有不是参数的配置项
     * 
     * @param applicationArguments
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        System.out.println("ApplicationRunner 开始执行了 order为2");
        System.out.println(applicationArguments.containsOption("server.port"));
        System.out.println(applicationArguments.getOptionValues("server.port"));
        System.out.println(applicationArguments.getOptionValues("name"));
    }
}
