package com.ek.guide.thread2.demo6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程锁
 * Test Lock ReentrantLock
 * 
 * @ClassName: Test1
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月21日 下午8:25:42
 */
public class Test1 {

  public static void main(String[] args) {

    Test1.Inner inner = new Test1().new Inner();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          inner.outPuter("wanghongmiao");
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          inner.outPuter("xiaoqiangqiang");
        }
      }
    }).start();

  }

  class Inner {

    // 声明一个锁 (这种锁不管读还是写都不能进来,读的时候就不能并发了)
    Lock lock = new ReentrantLock();

    public void outPuter(String name) {
      lock.lock(); // 锁住这里

      try {
        for (int i = 0; i < name.length(); i++) {
          System.out.print(name.charAt(i));
        }
        System.out.println();
      } finally { // 放在finally里释放锁,否则程序出现异常就不能执行是否锁了
        lock.unlock(); // 一个进程执行完成释放锁,让下一个进程可以获得所
      }
    }
  }

}
