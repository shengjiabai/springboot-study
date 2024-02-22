package com.bzy.service.retry.springRetry;


import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;

/**
 * @Author: 
 * @Description:
 */

public class RetryDemoTask {

  private static Logger log = LoggerFactory.getLogger(RetryDemoTask.class);

  /**
   * 重试方法
   * @return
   */
  public static boolean retryTask(String param)  {
    log.info("收到请求参数:{}",param);

    int i = RandomUtils.nextInt(0,11);
    log.info("随机生成的数:{}",i);
    if (i == 0) {
      log.info("为0,抛出参数异常.");
      throw new IllegalArgumentException("参数异常");
    }else if (i == 1){
      log.info("为1,返回true.");
      return true;
    }else if (i == 2){
      log.info("为2,返回false.");
      return false;
    }else{
      //为其他
        log.info("大于2,抛出自定义异常.");
        throw new RemoteAccessException("大于2,抛出远程访问异常");
      }
    }

}