package com.ek.guide.thread2.demo7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition (实现线程通讯,类似Object.wait和Object.notify的功能)
 * 还是那个例子子线程循环多少次,主线程循环多少次,往复交替
 * 
 * @ClassName: Test
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月21日 下午11:26:38
 */
public class Test1 {

  public static void main(String[] args) {
    Test1.Inner inner = new Test1().new Inner();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          inner.subT();
        }
      }
    }).start();

    
    
    for (int i = 0; i < 5; i++) {
      inner.mainT();
    }
  }

  
  
  
  class Inner {
    // 子线程执行的代码
    private boolean tag = false;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void subT() {
      lock.lock();
      try {
        while (tag) { // 用while不用if可以防止虚假唤醒
          try {
            condition.await(); // 相当于Object.wait
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        for (int i = 0; i < 10; i++) {
          System.out.println(Thread.currentThread().getName() + " SUB IS Running");
        }
        tag = true;
        condition.signal(); // 相当于Object.notify
      } finally {
        lock.unlock();
      }
    }

    
    
    // 主线程执行的代码
    public void mainT() {
      lock.lock();
      try {
        while (!tag) {
          try {
            condition.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        for (int i = 0; i < 5; i++) {
          System.out.println(Thread.currentThread().getName() + " Main IS Running");
        }
        tag = false;
        condition.signal();
      } finally {
        lock.unlock();
      }
    }
  }
}
