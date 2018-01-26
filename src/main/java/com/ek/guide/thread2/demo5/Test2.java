package com.ek.guide.thread2.demo5;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletionService 在线程池里找,哪个先执行完就先返回哪个
 * 
 * @ClassName: Test2
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月21日 下午7:39:15
 */
public class Test2 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
    
    for (int i = 0; i < 10; i++) { // 提交10个任务
      final int seq = i;
      completionService.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          Thread.sleep(new Random().nextInt(5000)); // 最多5的随机整数
          return seq;
        }
      });
    }
    
    // 哪提交的10个结果
    for(int i=0; i<10; i++){
      System.out.println(completionService.take().get());
    }
    
    threadPool.shutdown();

  }

}
