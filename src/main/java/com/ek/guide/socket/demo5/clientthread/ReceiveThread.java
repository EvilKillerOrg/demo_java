package com.ek.guide.socket.demo5.clientthread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import com.ek.guide.socket.demo5.utils.CloseStreamUtil;

/**
 * 接收线程
 * 接收线程类是后写的, 更详细的注释在发送线程类里看
 */
public class ReceiveThread implements Runnable {

  private DataInputStream in; // 客户端读取数据(输入流)
  private boolean isRunning = true; // 控制线程

  public ReceiveThread() {
  }

  public ReceiveThread(Socket client) {
    try {
      in = new DataInputStream(client.getInputStream());
    } catch (IOException e) {
      isRunning = false;
      CloseStreamUtil.closeAll(in);
    }
  }

  /* 接收数据 */
  public String receive() {
    String msg = "";
    try {
      msg = in.readUTF();
    } catch (IOException e) {
      isRunning = false;
      CloseStreamUtil.closeAll(in);
    }
    return msg;
  }

  /* 线程体 */
  @Override
  public void run() {
    while (isRunning) {
      System.out.println(receive());
    }
  }

}
