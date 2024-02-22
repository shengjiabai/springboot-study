package com.bzy.service.retry.springRetry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * 
 * https://mp.weixin.qq.com/s/lHDhQqVLoP3g98ExzGkl8g
         @EnableRetry 加这个注解
 * @Date: 18/11/22 14:10
 * @Description:
 */
@Service

public class SpringRetryDemo   {

    private static Logger log = LoggerFactory.getLogger(SpringRetryDemo.class);

 /**
   * 重试所调用方法
   * @param param
   * @return
   */
  @Retryable(value = {RemoteAccessException.class},maxAttempts = 3,backoff = @Backoff(delay = 2000L,multiplier = 2))
  public boolean call(String param){
      return RetryDemoTask.retryTask(param);
  }

  /**
   * 达到最大重试次数,或抛出了一个没有指定进行重试的异常
   * recover 机制
   * @param e 异常
   */
  @Recover
  public boolean recover(Exception e,String param) {
    log.error("达到最大重试次数,或抛出了一个没有指定进行重试的异常:",e);
    return false;
  }

}