package com.ek.guide.thread2.demo5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Callable And Future
 * 这玩意不知道有啥用
 * @ClassName: Test1
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月21日 下午7:19:42
 */
public class Test1 {
  public static void main(String[] args) throws Exception {
    ExecutorService threadPool = Executors.newSingleThreadExecutor();

    // Future可以等Callable执行完成以后,得到Callable执行的结果
    Future<String> future = 
      threadPool.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(1002);
        return "Hello";
      }
    });
    System.out.println("等待结果");
    // System.out.println("得到结果" + future.get());
    System.out.println("得到结果" + future.get(1, TimeUnit.SECONDS)); // 一秒之内得到结果, 得不到就抛异常
  }
}
