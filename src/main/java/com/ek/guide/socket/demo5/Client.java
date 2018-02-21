package com.ek.guide.socket.demo5;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ek.guide.socket.demo5.clientthread.ReceiveThread;
import com.ek.guide.socket.demo5.clientthread.SendThread;

/**
 * 创建客户端: 发送数据+接收数据
 * 客户端写出数据: 输出流 
 * 客户端读取数据: 输入流
 * 写出数据 和 读取数据 需要读取和写出同时 不能在同一个线程内 
 */
public class Client {

  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket client = new Socket("localhost", 8888);

    new Thread(new SendThread(client)).start(); 
    new Thread(new ReceiveThread(client)).start();
  }
}