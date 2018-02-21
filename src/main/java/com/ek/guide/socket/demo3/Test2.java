package com.ek.guide.socket.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * UDP
 * Client 客户端 (发送)
 * 测试时先运行服务端再运行客户端
 */
public class Test2 {
  public static void main(String[] args) throws IOException {
    // 1.创建客户端+端口
    DatagramSocket client = new DatagramSocket(6666);
    // 2.准备数据
    String msg = "udp编程";
    byte[] data = msg.getBytes(); // 把String转成字节数组
    // 3.打包(指定发送的地点以及端口)
    DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
    // 4.发送
    client.send(packet);
    // 5.释放
    client.close();
  }
}