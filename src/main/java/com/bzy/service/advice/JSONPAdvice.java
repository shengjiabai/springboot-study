//package com.bzy.service.advice;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;
//
///**
// * JSONP回调参数增强，跨域接口无需在每个controller单独封装jsonCallback
// * 适用用在springboot2.x以下的版本
// */
//@ControllerAdvice
//public class JSONPAdvice  extends AbstractJsonpResponseBodyAdvice {
//	
//	public JSONPAdvice() {
//        super("jsonCallback","jsonCallBack","jsoncallback","callback");
//    }
//
//}