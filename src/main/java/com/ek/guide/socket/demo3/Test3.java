package com.ek.guide.socket.demo3;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP
 * Server 服务端 (接收)
 * 测试时先运行服务端再运行客户端
 * Test1,Test2发送的是字符串 Test3,Test4发送的是double类型
 */
public class Test3 {
  public static void main(String[] args) throws IOException {

    // 1.创建服务端+端口
    DatagramSocket server = new DatagramSocket(8888);
    // 2.准备接收容器
    byte[] container = new byte[1024];
    // 3.封装成包
    DatagramPacket packet = new DatagramPacket(container, container.length);
    // 4.接收数据
    server.receive(packet);
    // 5.分析数据 字节数组 --> double
    double data = convert(packet.getData());
    System.out.println(data);// 转成字符串
    //6.释放资源
    server.close();
  }
  
  /* 字节数组 + Data输入流 */
  public static double convert(byte[] data) throws IOException{
    DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
    double num = dis.readDouble();
    dis.close();
    return num;
  }
}