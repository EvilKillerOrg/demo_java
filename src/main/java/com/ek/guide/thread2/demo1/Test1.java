package com.ek.guide.thread2.demo1;
/**
 * @ClassName: ThreadDemo1
 * @Description: 开启线程方法
 * @author: ek
 * @date: 2017年10月30日 下午5:50:25
 */
public class Test1 {
  public static void main(String[] args) {
    Thread thread = new Thread(){ //new Thread(){} 代表new的不是Thread而是Thread的子类(匿名内部类?)
      @Override
      public void run() {
        while(true){ //死循环cpu不停的执行循环
          try {
            Thread.sleep(500); //cpu休息500ms再次执行循环
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName());
        }
      }
    }; 
    thread.start();
    
    
    /* 创建Thread的子类 以覆盖Thread的run方法.*/
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName()); // 获得当前线程对象 和他的名字
        }
      }
    });
    thread2.start(); //启动该线程。
  }
}