package com.ek.guide.socket.demo1;

import java.net.InetSocketAddress;

/**
 * IP
 * InetSocketAddress 在InetAddress的基础上封装了端口
 */
public class Test2 {
  public static void main(String[] args) {
    // InetSocketAddress addr1 = new
    // InetSocketAddress(InetAddress.getLocalHost(),9999);
    InetSocketAddress addr1 = new InetSocketAddress("127.0.0.1", 9999);
    System.out.println(addr1.getHostName());
    System.out.println(addr1.getPort()); // 端口
  }

}