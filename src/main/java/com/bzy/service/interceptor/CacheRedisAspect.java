package com.bzy.service.interceptor;

import com.bzy.service.annotation.CacheUsed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 所有使用锅cacheUsed注解的地方进行拦截
 */
@Aspect
@Component
public class CacheRedisAspect {

    private static Logger LOGGER = LogManager.getLogger(CacheRedisAspect.class);
    /**
     * 默认redis缓存时间 1800s 30分钟
     */
    private static final Integer DEFAULT_EXPIRE_TIME_SECONDS = 1800;
    /**
     * 默认防止击穿 缓存时间
     */
    private static final Integer DEFAULT_PREVENT_BREAKDOWN_EXPIRE_TIME_SECONDS = 60;

    @Around(value = "@annotation(cacheUsed)")
    public Object query(ProceedingJoinPoint joinPoint, CacheUsed cacheUsed) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();
        String fieldKey = parseKey(cacheUsed.fieldKey(), method, args);
        if (StringUtils.isEmpty(fieldKey)) {
            return null;
        }
        String cacheKey = cacheUsed.keyPrefix() + fieldKey;
        CacheUsed.CacheOperation cacheOperation = cacheUsed.cacheOperation();
        if (cacheOperation == CacheUsed.CacheOperation.QUERY) {
            Class<?> returnType = method.getReturnType();
            return processQueryFromRedis(joinPoint, cacheUsed, cacheKey, returnType);
        }
        return joinPoint.proceed();
    }


    /**
     * 获取redis的key
     */
    private String parseKey(String fieldKey, Method method, Object[] args) {
        String returnStr = null;
        try {
            // 获取被拦截方法参数名列表(使用Spring支持类库)
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paraNameArr = u.getParameterNames(method);

            // 使用SPEL进行key的解析
            ExpressionParser parser = new SpelExpressionParser();
            // SPEL上下文
            StandardEvaluationContext context = new StandardEvaluationContext();
            // 把方法参数放入SPEL上下文中
            for (int i = 0; i < paraNameArr.length; i++) {
                if (args[i] instanceof Date) {
                    //args[i] = DateFormatUtils.format((Date) args[i], "yyyyMMdd");
                }
                context.setVariable(paraNameArr[i], args[i]);
            }
            returnStr = parser.parseExpression(fieldKey).getValue(context, String.class);
        } catch (Exception e) {
            LOGGER.error("获取redis的key error ",e);
            return "";
        }
        return returnStr;
    }

    /**
     * 查询处理
     */
    private Object processQueryFromRedis(ProceedingJoinPoint point, CacheUsed cacheUsed,
                                         String cacheKey, Class returnObject) throws Throwable {
//        Object result;
//        CacheRedisClient cacheRedisClient = CacheRedisClient.getCacheRedisClient();
//
//        if (cacheRedisClient.exist(cacheKey)) {
//            String resultStr = cacheRedisClient.getString(cacheKey);
//            return JSONObject.parseObject(resultStr, returnObject);
//        } else {
//            result = point.proceed();
//            if(result==null){
//                cacheRedisClient.set(cacheKey, JSONObject.toJSONString(null), (int) TimeUnit.SECONDS.convert(DEFAULT_PREVENT_BREAKDOWN_EXPIRE_TIME_SECONDS, TimeUnit.SECONDS));
//                return null;
//            }
//            // 被切业务如果无异常，无论是否有结果，都保存为缓存数据。
//            int expire = cacheUsed.expireTime();
//            TimeUnit timeUnit = cacheUsed.timeUnit();
//            // 未设置缓存数据有效时间的情况下
//            if (expire <= 0) {
//                // 缓存数据的有效时间默认为30分钟
//                cacheRedisClient.set(cacheKey, JSONObject.toJSONString(result), (int) TimeUnit.SECONDS.convert(DEFAULT_EXPIRE_TIME_SECONDS, timeUnit));
//            } else {
//                // 换算成秒 并且存入redis
//                cacheRedisClient.set(cacheKey, JSONObject.toJSONString(result), (int) TimeUnit.SECONDS.convert(expire, timeUnit));
//            }
//            return result;
//        }
        return false;
    }



}
