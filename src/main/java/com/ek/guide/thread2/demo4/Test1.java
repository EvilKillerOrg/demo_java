package com.ek.guide.thread2.demo4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java5线程并发库-线程池
 * 
 * @ClassName: Test1
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月21日 下午6:15:55
 */
public class Test1 {

  public static void main(String[] args) {

    // 1. 固定大小线程池; 参数是固定的线程数(比如这是3个线程的池)
    /* ExecutorService threadPool = Executors.newFixedThreadPool(3); */

    // 2. 缓存线程池; 内部的线程个数是不定的, 动态创建需要的线程个数
    /* ExecutorService threadPool = Executors.newCachedThreadPool(); */

    // 3. 单线程池; 在一个线程死了的时候再重新启动一个线程
    ExecutorService threadPool = Executors.newSingleThreadExecutor();
    
    for (int i = 0; i < 10; i++) { // 创建10个任务 放到线程池里去 ,同时只有3个线程被服务
      final int task = i; // 下面需要放一个final的,这弄一个
      threadPool.execute(new Runnable() {
        @Override
        public void run() {
          for (int j = 0; j < 10; j++) {
            try {
              Thread.sleep(200);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            System.out.println("第" + task + "个任务 在" + Thread.currentThread().getName() + " 第" + j + "次循环");
          }
        }
      });
    }
    threadPool.shutdown(); // 没有任务了 结束掉线程池
  }
}
