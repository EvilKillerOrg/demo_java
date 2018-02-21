package com.ek.guide.socket.demo3;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * UDP
 * Client 客户端 (发送)
 * 测试时先运行服务端再运行客户端
 * Test1,Test2发送的是字符串 Test3,Test4发送的是double类型
 */
public class Test4 {
  public static void main(String[] args) throws IOException {
    // 1.创建客户端+端口
    DatagramSocket client = new DatagramSocket(6666);
    // 2.准备数据 double --> 字节数组 字节数组输出流(从内存输出给容器)
    double num = 89.12;
    byte[] data = convert(num);
    // 3.打包(指定发送的地点以及端口)
    DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
    // 4.发送
    client.send(packet);
    // 5.释放
    client.close();
  }

  /* 使用字节数组作为数据源 + Data输出流 */
  public static byte[] convert(double num) throws IOException {
    byte[] data = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(bos);
    dos.writeDouble(num);
    dos.flush();
    data = bos.toByteArray();
    dos.close();
    return data;
  }
}