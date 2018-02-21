package com.ek.guide.socket.demo4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket编程
 * Server 服务端 (接收一个客户端)
 * 
 * Socket指的是 服务端和客户端之间的管道,并不是指服务端或客户端,一条管道对应一个客户端
 * 一方的输出流就是另一方的输入流,一方的输入流就是另一方的输出流
 * 
 * 必须先运行server
 */
public class Test1 {
  public static void main(String[] args) throws IOException {
    // 1.创建服务器 指定端口
    ServerSocket server = new ServerSocket(8888);
    // 2.接收客户端的连接 (这个连接是一个阻塞式的,会一直等待客户端直到建立链接)
    Socket socket = server.accept();
    System.out.println("一个客户端建立链接!");
    // 3.发送数据+接收数据
    // 3.1.发送数据 输出流
    String msg = "欢迎使用!";
    /* 
    使用Buffered 下面是使用 Data (服务端和客户端要成对使用,要用一样的)
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    bw.write(msg);
    bw.newLine();  这里加一行 因为BufferedReader是逐行读的,必须有一个行结束符,这加一行前面的行就有结束符了
    bw.flush();
    bw.close(); 不要关闭,服务器是不间断服务的
    */
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    dos.writeUTF(msg);
    dos.flush();
  }
}
