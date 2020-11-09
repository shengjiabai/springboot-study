package com.bzy.service.other;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Arrays;

/**
 * 布隆过滤器  guava
 */
public class BloomFilterTest {


    public static void main(String[] args) {
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);

       
                // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        System.out.println(filter.mightContain(3));
        
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.get();
        //
        Object obj  =  new Object();
    }
    
    
    /*
    
    MyBatis你只写了接口为啥就能执行sql啊?
    答：因为mybatis使用动态代理帮我们生成了接口的实现类，这个类就是org.apache.ibatis.binding.MapperProxy
    java.util.concurrent下面有哪些类？
    答：atomicLong 等，jdk8新加LongAdder、CountDownLatch、CyclicBarrier、queue(同步队列、有界队列、无界队列)、callabe、ThreadPoolExecutor、Executors、
       Future、CompletableFuture、ReentrantLock、ConcurrentHashMap、CopyOnWriteArrayList、TimeUnit、ThreadFactory
    * */
}
