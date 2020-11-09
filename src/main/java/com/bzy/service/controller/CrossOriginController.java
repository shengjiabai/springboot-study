package com.bzy.service.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CrossOrigin跨域测试
 */
@RestController
@RequestMapping("/cross")
@CrossOrigin //所有域名均可访问该类下所有接口
//@CrossOrigin("https://blog.csdn.net") // 只有指定域名可以访问该类下所有接口
@Api(tags = { "跨域测试"})
public class CrossOriginController {


    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello world --- 2";
    }
    
}

/**
 * 
 * spring boot 2.0以后支持跨域的方式有2种
 *  第一种：直接在类或者方法上加@CrossOrigin注解（详细配置可以点进去看源码）
 *  第二种：通过配置WebMvcConfigurer对象来定义全局CORS配置。
 *        示例：config报下的WebConfig实现addCorsMappings

 */
 