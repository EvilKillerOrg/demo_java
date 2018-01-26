package com.ek.guide.thread2.demo3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内的共享数据
 * 
 * 现在有两个线程 ,线程一和线程二 ,另外有ABC3个对象; 
 * 当线程一调用ABC3个对象时访问数据one; 
 * 当线程二调用ABC3个对象时访问数据two;
 * 也就是说换了线程 abc 取得的数据就不一样了.
 * 
 * @ClassName: Test1
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月18日 下午8:32:14
 */
public class Test1 {
  
  private static Map<Thread, Integer> dataMap = new HashMap<Thread, Integer>();//共享数据集合 

  public static void main(String[] args) {
    // 创建两个线程
    for (int i = 0; i <2; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          int data = new Random().nextInt(); // 造数据  
          System.out.println(Thread.currentThread().getName() + " created data is " + data);
          dataMap.put(Thread.currentThread(), data); // 将数据放入集合，以便线程操作数据  
          new A().aGet();
          new B().bGet();
          new C().cGet();
        }
      }).start();
    }
  }

  
  
  
  
  // 对象A
  static class A {
    public void aGet() {
      int data = dataMap.get(Thread.currentThread()); // 根据当前线程取得数据  
      System.out.println(Thread.currentThread().getName() + "----A get data = " + data);
    }
  }

  // 对象B
  static class B {
    public void bGet() {
      int data = dataMap.get(Thread.currentThread()); // 根据当前线程取得数据
      System.out.println(Thread.currentThread().getName() + "----B get data = " + data);
    }
  }

  // 对象C
  static class C {
    public void cGet() {
      int data = dataMap.get(Thread.currentThread()); // 根据当前线程取得数据
      System.out.println(Thread.currentThread().getName() + "----C get data = " + data);
    }
  }
}
