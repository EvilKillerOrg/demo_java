package com.ek.guide.thread2.demo2;

/**
 * 线程的互斥
 * 
 * 线程不同步的话有一个问题就是一个线程没有执行完,cpu就有可能去执行另一个进程 比如说 线程1打印张三的时候还没打印完,
 * 光打印了个张,CPU就有可能去执行线程2打印李四去了,线程2还没打印完打印个李,CPU就有可能又去执行线程去1了
 * 
 * @ClassName: Test1
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月18日 下午2:20:46
 */
public class Test1 {

  public static void main(String[] args) {

    // 实例化内部类
    OutPuter outPuter = new Test1().new OutPuter();

    // 启动线程1
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          outPuter.output("张三");
        }
      }
    }).start();
    
    

    // 启动线程2
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          outPuter.output("李四");
        }
      }
    }).start();

  }

  
  /* 打印名字的内部类 */
  class OutPuter {
    public void output(String name) {
      int len = name.length();

       /*
       * 要实现互斥synchronized传入的必须是同一个对象,传name不行name会指向不同的两个对象,
       * 不过一般直接传this就行了,也可以是OutPuter.class
       * 或者把synchronized放在方法上就可以了(如果方法上有synchronized方法里面也有synchronized会出现死锁)
       * 要是两个类要同步就是这样synchronized(XXX.class)
       * 反正就是要同步就必须synchronized同一个对象,synchronized就是一把锁,必须要锁同一个对象
       * 使用类的字节码虽然万能,但是当同步的需求复杂的时候就不好弄了
       */
      String xxx = "";
      synchronized (xxx) { // 解决的办法是把要保护的代码用synchronized包起来,实现排他性(互斥)
        for (int i = 0; i < len; i++) {
          System.out.print(name.charAt(i));
        }
        System.out.println("----------------------");
      }
    }
  }
}
