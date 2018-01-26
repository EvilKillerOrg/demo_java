 package com.ek.guide.thread2.demo3;

import java.util.Random;

/**
 * 使用 ThreadLocal 可以很方便的实现线程范围内共享数据 (实际上ThreadLocal这个类就是一个Map)
 * ThreadLocal 就可以存当前线程上的变量
 * @ClassName: Test2
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月18日 下午10:25:45
 */
public class Test2 {

  private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();// 共享数据集合
  // 创建两个线程

  public static void main(String[] args) {
    for (int i = 0; i < 2; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          int data = new Random().nextInt(); // 造数据
          System.out.println(Thread.currentThread().getName() + "Created data is " + data);
          threadLocal.set(data);// 将数据放入集合，以便线程操作数据
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
      int data = threadLocal.get();
      System.out.println(Thread.currentThread().getName() + "----A get data = " + data);
    }
  }
  
  
  
  // 对象B
  static class B {
    public void bGet() {
      int data = threadLocal.get();
      System.out.println(Thread.currentThread().getName() + "----A get data = " + data);
    }
  }
  
  
  
  // 对象C
  static class C {
    public void cGet() {
      int data = threadLocal.get();
      System.out.println(Thread.currentThread().getName() + "----A get data = " + data);
    }
  }
}
