package com.bzy.service.config;

import com.bzy.service.interceptor.LogInterceptor;
import com.bzy.service.interceptor.WatchInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * 
 * 
 * WebMvcConfigurerAdapter 抽象类是对WebMvcConfigurer接口的简单抽象（增加了一些默认实现），但在在SpringBoot2.0及Spring5.0中WebMvcConfigurerAdapter已被废弃 。
 * 官方推荐直接实现WebMvcConfigurer或者直接继承WebMvcConfigurationSupport
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/**")
                //这里add为“/**”,下面的exclude才起作用，且不管controller层是否有匹配客户端请求，拦截器都起作用拦截
//                .addPathPatterns("/hello")
                //如果add为具体的匹配如“/hello”，下面的exclude不起作用,且controller层不匹配客户端请求时拦截器不起作用

                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/wang")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**");
        //这里可以用registry.addInterceptor添加多个拦截器实例，后面加上匹配模式
        registry.addInterceptor(new WatchInterceptor());
      
    }


    /**
     * 注册跨域
     * @param registry
     *
     * spring boot 2.0以后支持跨域的方式有2种
     *  第一种：直接在类或者方法上加@CrossOrigin注解（详细配置可以点进去看源码）
     *  第二种：通过配置WebMvcConfigurer对象来定义全局CORS配置。
     *        示例：config报下的WebConfig实现addCorsMappings

     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOrigins("https://www.dustyblog.cn"). //允许跨域的域名，可以用*表示允许任何域名使用
                allowedMethods("*"). //允许任何方法（post、get等）
                allowedHeaders("*"). //允许任何请求头
                allowCredentials(true). //带上cookie信息
                exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
    }
}