package com.ek.guide.thread2.demo2;

/**
 * 线程通讯
 * 子线程循环10次,接着主线程循环10次,接着又回到子线程循环10次, 接着再回到主线程又循环10次,如此循环5次
 * 
 * @ClassName: Ex1
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月18日 下午4:23:49
 */

public class Test2 {

  public static void main(String[] args) {

    Test2.Business business = new Test2().new Business();

      
      // 创建子线程
      new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 1; i <= 5; i++) {
          business.subT();
          }
        }
      }).start();

      
      // 这是主线程(main方法本身占用的进程)
      for (int i = 1; i <= 5; i++) {
      business.mainT();
      }
  }

  
  
  
  class Business {

    private boolean tag = false;

    /*
     * false让子进程wait,唤醒主进程 true让子进程执行
     * 
     */

    // 子线程执行的代码
    public synchronized void subT() {
      while (tag) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      for (int j = 1; j <= 10; j++) {
        System.out.println("-子线程" + Thread.currentThread().getName() + "--" + j);
      }
      tag = true; 
      this.notify(); //唤醒一个线程
    }

    
    
    
    // 主线程执行的代码(程序总是先走主进程,所以这里要让主进程先wait)
    public synchronized void mainT() {
      while (!tag) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      for (int j = 1; j <= 10; j++) {
        System.out.println("-------主线程" + Thread.currentThread().getName() + "--" + j);
      }
      tag = false;
      this.notify();
    }
  }
}
