package com.ek.guide.thread2.demo8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 同步工具-1
 * Semaphore 可以维护当前访问自身的线程个数,并提供了同步机制. 使用Semaphore可以控制同时访问资源的线程个数.
 * 例如,实现一个文件允许的并发访问数
 * 
 * @ClassName: Test1
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月22日 上午1:42:57
 */
public class Test1 {
  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();
    Semaphore sp = new Semaphore(3);
    for(int i=0;i<10;i++){
      Runnable runnable = new Runnable(){
        @Override
        public void run() {
          
        }
        
      };
    }
  }
}
