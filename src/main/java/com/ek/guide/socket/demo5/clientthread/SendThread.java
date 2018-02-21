package com.ek.guide.socket.demo5.clientthread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.ek.guide.socket.demo5.utils.CloseStreamUtil;

/**
 * 发送线程
 */
public class SendThread implements Runnable {

  private BufferedReader console; // 控制台输入流
  private DataOutputStream out; // 客户端写出数据(输出流)
  private boolean isRunning = true; // 控制线程

  /* 在这个无参构造器中 实例化控制台输入流 */
  public SendThread() {
    console = new BufferedReader(new InputStreamReader(System.in));
  }

  /* 在这个构造器中传入一个client 实例化 写出数据(输出流) */
  public SendThread(Socket client) {
    this(); // 这是调用上面的无参构造器 (构造器只能被构造器调用，不能被其他方法调用)
    try {
      out = new DataOutputStream(client.getOutputStream());
    } catch (IOException e) {
      isRunning = false;
      CloseStreamUtil.closeAll(out, console); // 初始化的时候出现异常 就把开启的流全都关了 没必要输出异常了
    }
  }

  /* 1.从控制台接收数据(有界面的话就从文本框来了就不用写这个了) */
  private String getMsgFromConsole() {
    try {
      return console.readLine();
    } catch (IOException e) {
    }
    return null;
  }

  /* 2.发送数据 */
  public void send() {
    String msg = this.getMsgFromConsole();
    try {
      if (null != msg && !"".equals(msg)) {
        out.writeUTF(msg);
        out.flush(); // 强制刷新
      }
    } catch (IOException e) {
      isRunning = false;
      CloseStreamUtil.closeAll(out, console); // 初始化的时候出现异常 就把开启的流全都关了
    }
  }

  /* 线程体 */
  @Override
  public void run() {
    while (isRunning) {
      this.send();
    }
  }
}