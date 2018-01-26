package com.ek.guide.thread2.demo1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 * //可以使用一个开源的工具Quartz实现定时器
 * @ClassName: Test2
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月18日 下午1:23:58
 */
public class Test2 {

  //schedule()还有一个重载的方法可以传具体时间值
  public static void main(String[] args) {
    new Timer().schedule(new TimerTask() { // schedule(调度)

      @Override
      public void run() {
        System.out.println("bombing");
      }

    }, 10000,3000); // 10秒以后启动任务,然后每间隔3秒执行一次
    while (true) {
      System.out.println(new Date().getSeconds()); // 打印当前秒数
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

}
