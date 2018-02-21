package com.ek.guide.socket.demo5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.ek.guide.socket.demo5.utils.CloseStreamUtil;

/**
 * 创建服务端
 * 服务端接收数据: 输入流(就是客户端的输出流)
 * 服务端发送数据: 输出流(就是客户端的输入流)
 */
public class Server {

  private List<MyChannel> list = new ArrayList<MyChannel>(); // 把建立的所有管道放在一个list里

  public static void main(String[] args) throws IOException {
    Server server = new Server();
    server.startInner();
  }

  /* 
   实例化内部类 静态方法实例化成员内部类可以用new外部类new内部类 也可以下面这样 
   MyChannel channel = new Server().new MyChannel(client);
   */
  public void startInner() throws IOException {
    ServerSocket server = new ServerSocket(8888);
    while (true) {
      Socket client = server.accept();
      MyChannel channel = new MyChannel(client);
      list.add(channel); // 建立的管道放在list里,统一管理
      new Thread(channel).start();
    }
  }

  /* 内部类 实现一个客户端一个线程 */
  private class MyChannel implements Runnable {
    private DataInputStream in; // 接收数据(输入流)
    private DataOutputStream out; // 发送数据(输出流)
    private boolean isRunning = true; // 线程标识

    /* 在构造器中初始化 */
    private MyChannel(Socket client) {
      try {
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
      } catch (IOException e) {
        CloseStreamUtil.closeAll(out, in);
        isRunning = false;
      }
    }

    /* 接收数据 */
    public String receive() {
      String msg = "";
      try {
        msg = in.readUTF();
      } catch (IOException e) {
        CloseStreamUtil.closeAll(in);
        isRunning = false;
        list.remove(this); // 出现异常移除自身
      }
      return msg;
    }

    /* 发送数据 */
    public void send(String msg) {
      if (null == msg || "".equals(msg)) {
        return;
      }
      try {
        out.writeUTF("服务器-->" + msg); // 服务器发出去
        out.flush();
      } catch (IOException e) {
        CloseStreamUtil.closeAll(out);
        isRunning = false;
        list.remove(this); // 出现异常移除自身
      }
    }

    /* 遍历所有的管道 把接收的数据发送给其他客户端 */
    private void sendToOthers() {
      String msg = this.receive();
      for (MyChannel channel : list) {
        if (channel == this) { // 不要发送给自己(this代表谁调用就是谁)
          continue; // 是自己就跳过
        }
        channel.send(msg); // 转发给其他所有人(群聊)
      }
    }

    /* 线程体 */
    @Override
    public void run() {
      while (isRunning) {
        sendToOthers();
      }
    }
  }
}
