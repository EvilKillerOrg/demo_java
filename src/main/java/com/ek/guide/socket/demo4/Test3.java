package com.ek.guide.socket.demo4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Socket编程
 * Client 客户端
 * 
 * Socket指的是 服务端和客户端之间的管道,并不是指服务端或客户端,一条管道对应一个客户端
 * 一方的输出流就是另一方的输入流,一方的输入流就是另一方的输出流
 * 
 * 必须先运行server
 */
public class Test3 {
  public static void main(String[] args) throws IOException {
    // 1.创建客户端 必须指定服务器端+端口, 此时就在链接
    Socket client = new Socket("localhost", 8888);
    // 2.接收数据+发送数据
    // 2.1.接收数据 输入流
    /* 
    使用Buffered 下面是使用 Data (服务端和客户端要成对使用,要用一样的)
    BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
    String echo = br.readLine();
    System.out.println(echo);
    */
    DataInputStream dis = new DataInputStream(client.getInputStream());
    String echo = dis.readUTF();
    System.out.println(echo);
  }
}
