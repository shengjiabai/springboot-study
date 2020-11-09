package com.bzy.service.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com\bzy\service\advice\ResponseBodyAdviceTest.java
 */
@Controller
@RequestMapping("/test")
@Api(tags = { "测试拦截器"})
public class ResponseBodyAdviceController {

    @RequestMapping("/not/ResponseBodyAdviceTest")
    public Object ResponseBodyAdviceTest(){
        return "没有@ResponseBody注解，不会执行ResponseBodyAdvice增强器";
    }

    @RequestMapping("/ResponseBodyAdviceTest")
    @ResponseBody
    public Object ResponseBodyAdviceTest1(){
        return "会执行ResponseBodyAdvice增强器";
    }
}
