package com.ek.guide.socket.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP
 * Server 服务端 (接收)
 * 测试时先运行服务端再运行客户端
 */
public class Test1 {
  public static void main(String[] args) throws IOException {

    // 1.创建服务端+端口
    DatagramSocket server = new DatagramSocket(8888);
    // 2.准备接收容器
    byte[] container = new byte[1024];
    // 3.封装成包
    DatagramPacket packet = new DatagramPacket(container, container.length);
    // 4.接收数据
    server.receive(packet);
    // 5.分析数据
    byte[] data = packet.getData();
    int len = packet.getLength();
    System.out.println(new String(data, 0, len));// 转成字符串
    //6.释放资源
    server.close();
  }
}