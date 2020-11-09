package com.bzy.service.interceptor;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 线程打印controller消耗时间Interceptor
 * @author chentianming
 *
 */
public class WatchInterceptor implements HandlerInterceptor {
    public static final Log log = LogFactory.getLog(WatchInterceptor.class);
    
    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("StopWatch-StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();// 1、开始时间
        startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
        String logId = UUID.randomUUID().toString();
		ThreadContext.put("logId", logId);
        
        return true;// 继续流程
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();// 2、结束时间
        long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - beginTime;// 3、消耗的时间
        if(consumeTime>300){
            log.info(String.format("Execute Controller cost than 300 url:[%s] param:[%s] consume %d ms", request.getRequestURI(), request.getParameterMap().toString(),consumeTime));
        }else{
            log.info(String.format("Execute Controller [%s]!200 consume %d ms", request.getRequestURI(), consumeTime));
        }
        startTimeThreadLocal.remove();
    }

}
