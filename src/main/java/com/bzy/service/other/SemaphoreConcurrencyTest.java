package com.bzy.service.other;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 
 * 降速，协调资源的使用：刚说完提速，这里又说降速，许多人可能会很奇怪。
 * 这里举具体例子来说明一下，比如项目里要发短信，目前有第三方的限制是并发量最多10条，
 * 而每天高峰期时段同一时刻需要发送的短信量可能远高于10条，这时怎么办呢？就可以在发短信时引入线程池及多线程池处理，
 * 通过semaphore等控制同时发短信的线程不超过10，这样就起到了降速的作用。
 */
public class SemaphoreConcurrencyTest {
    // 请求的总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    testMethod();
                    semaphore.release();
                } catch (Exception e) {
                   // log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        // 所有线程执行完，之后才能执行的部分
    }
    private static void testMethod() {
        // 待验证的方法
    }



}
