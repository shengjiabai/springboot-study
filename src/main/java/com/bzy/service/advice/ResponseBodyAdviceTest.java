package com.bzy.service.advice;

import com.bzy.service.annotation.IgnoreResponseAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.swagger.web.ApiResourceController;

import javax.servlet.http.HttpServletRequest;

/**
 * ResponseBodyAdvice : 可以对@ResponseBody的返回值进行加工处理，它是一个接口类，具体处理可以自定义实现类注入到responseBodyAdviceBeans中既可，
 * 注入过程由RequestMappingHandlerAdapter类的initControllerAdviceCache去做，开发者只需要自定义实现类实现ResponseBodyAdvice 接口并添加类注解@ControllerAdvic
 */

@ControllerAdvice//ControllerAdvice是springmvc controller增强器
public class ResponseBodyAdviceTest implements ResponseBodyAdvice {

    /**
     * 判断那些类型需要拦截，只有这里返回true下面的beforeBodyWrite方法才会执行
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //注意，这里必须返回true，否则不会执行beforeBodyWrite方法 
       // return false;

        //swagger页面的请求不拦截
        if(methodParameter.getDeclaringClass() == ApiResourceController.class ||
                methodParameter.getDeclaringClass() ==  springfox.documentation.swagger2.web.Swagger2Controller.class
        ){
            return false;
        }
        
        
        //存在类注解和方法注解不拦截
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)
                ||methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class) ){
            return false;
        }
        return true;
        
        //基于class做判断
       // return aClass == StringHttpMessageConverter.class;

        //swagger页面的请求不拦截
//        if(methodParameter.getDeclaringClass() == ApiResourceController.class ||
//                methodParameter.getDeclaringClass() ==  springfox.documentation.swagger2.web.Swagger2Controller.class
//        ){
//            return false;
//        }
        
    }

    /**
     * 拦截之后执行
     * @param o  
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
        return  o;
    }
}
