package com.ek.guide.socket.demo6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket编程 (HTTPServer 客户端是浏览器)
 */
public class Server {

  private ServerSocket server;

  public static void main(String[] args) {
    Server server = new Server();
    server.start();

  }

  /* 创建Server */
  public void start() {

    try {
      server = new ServerSocket(8888);
      this.receive();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /* 接收Client */
  private void receive() {
    try {
      Socket client = server.accept();
      StringBuilder sb = new StringBuilder();
      String msg = null; // 接收客户端的请求信息
      BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
      while ((msg = br.readLine()).length() > 0) {
        sb.append(msg);
        sb.append("/r/n");
         if(null==msg){
         break; //break是结束整个循环体，continue是结束单次循环
         }
      }
      System.out.println((sb.toString()).trim());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /* 停止Server服务 */
  public void stop() {

  }

}
