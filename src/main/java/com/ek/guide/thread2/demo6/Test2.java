package com.ek.guide.thread2.demo6;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 
 * @ClassName: Test2
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月21日 下午9:38:00
 */
public class Test2 {

  public static void main(String[] args) {

    Test2.Queue queue = new Test2().new Queue();

    // 创建3个进程用来读
    for (int i = 0; i < 3; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          while (true) {
            queue.get();
          }
        }
      }).start();
    }

    // 创建1个进行用来写
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          queue.put(new Random().nextInt(10000));
        }
      }
    }).start();
  }

  
  
  class Queue { // 读和写要互斥所以要放在同一个类里
    private Object data = null; // 共享数据,只能有一个进程能写该数据,但可以有多个进程同时读该数据.
    ReadWriteLock rwl = new ReentrantReadWriteLock(); // 读写锁

    // 读资源的方法
    public void get() {
      rwl.readLock().lock(); // 读锁
      try {
        System.out.println(Thread.currentThread().getName() + " 开始读");
        System.out.println(Thread.currentThread().getName() + " 读到: " + data);
        Thread.sleep((long) Math.random() * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        rwl.readLock().unlock(); // 进程使用完了释放锁
      }
    }

    
    // 写资源的方法
    public void put(Object writeData) {
      rwl.writeLock().lock();
      try {
        System.out.println(Thread.currentThread().getName() + " 开始写");
        Thread.sleep((long) Math.random() * 1000);
        this.data = writeData;
        System.out.println(Thread.currentThread().getName() + " 写了: " + writeData);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }finally{
        rwl.writeLock().unlock();
      }
    }
  }
}
