package com.ek.guide.socket.demo4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket编程
 * Server 服务端 (接收多个客户端)
 * 
 * Socket指的是 服务端和客户端之间的管道,并不是指服务端或客户端,一条管道对应一个客户端
 * 一方的输出流就是另一方的输入流,一方的输入流就是另一方的输出流
 * 
 * 必须先运行server
 */
public class Test2 {
  public static void main(String[] args) throws IOException {
    // 1.创建服务器 指定端口
    ServerSocket server = new ServerSocket(8888);
    // 2.接收客户端的连接 (这个连接是一个阻塞式的,会一直等待客户端直到建立链接)
    while (true) { // 死循环 一个accept()一个客户端
      Socket socket = server.accept();
      System.out.println("一个客户端建立链接!");
      // 3.发送数据+接收数据
      // 3.1.发送数据 输出流
      String msg = "欢迎使用!";
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      dos.writeUTF(msg);
      dos.flush();
      /* 
      1.这里服务端有个问题就是要给一个客户端发送数据完毕,下一个客户端才能链接
      所以服务器应该使用多线程操作
      2.客户端发送数据和接收数据 应该是相互独立的. 
      每一个客户端应该创建一个线程
      代码看 demo5 是一个聊天室
      */
    }
  }
}
