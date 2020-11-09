package com.bzy.service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface CacheUsed {
    /**
     * key前缀
     */
    String keyPrefix() ;
    /**
     * key主体，spel表示，例：#id（取形参中id的值）
     */
    String fieldKey();
    /**
     * 过期时间.0:表示随系统业务设定
     */
    int expireTime() default 60;

    TimeUnit timeUnit() default TimeUnit.SECONDS;

    CacheOperation cacheOperation() default CacheOperation.QUERY;


    /**
     * 缓存操作类型
     */
    enum CacheOperation {
        QUERY, // 查询
        REFRESH, // 刷新缓存
        UPDATE, // 修改
        DELETE; // 删除
    }

    /**
     * 缓存类型
     * REDIS_ONLY  单单redis缓存
     * EHCACHE_REDIS  同时 ehcache redis缓存
     */
    enum CacheType {
        REDIS_ONLY,
        EHCACHE_REDIS
    }

}
