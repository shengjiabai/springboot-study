package com.bzy.service.runner;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用InitializingBean接口优雅加载配置文件属性到常量类的一种方式
 * 
 * 在spring框架中，InitializingBean接口为bean提供了初始化方法的方式，它只包括afterPropertiesSet()方法，凡是继承该接口的类，在初始化bean的时候都会执行该方法。我们将常量类作为一个Bean进行初始化，并实现了InitializingBean接口，通过实现其afterPropertiesSet()方法将在配置文件中加载到的值赋给静态常量。从而在代码使用使用该常量类调用获取对应的常量。
 * ————————————————
 * 原文链接：https://blog.csdn.net/qq_41923982/article/details/106267665
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件内容
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.file.keyid}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;

    //定义公开静态常量
    public static String END_POIND;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    // 该方法在项目启动的初始化Bean时,设置完当前Bean的参数后执行. 将上述bean属性赋值给公开静态常量.
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POIND = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
