package com.ek.guide.io.second.demo06;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组流(节点流)
 * 数组的长度有限,数据量不会很大
 */
public class ByteArrayStream {

  public static void main(String[] args) throws IOException {
    read(writer());
  }

  /**---------<br>
   * 操作与文件输入流操作不一样
   */
  public static byte[] writer() throws IOException {
    // 目的地
    byte[] dest;
    // 选择流,不用在构造器中把dest给ByteArrayOutputStream
    ByteArrayOutputStream out = new ByteArrayOutputStream(); //这不要多态,因为要用子类的toByteArray()方法
    // 操作 写出
    String msg = "字节数组流";
    byte[] info = msg.getBytes(); // 字符串转换成字节数组
    out.write(info, 0, info.length); // 写出到管道中
    // 获取数据
    dest = out.toByteArray();
    // 释放
    out.close();
    return dest;
  }

  /**---------<br>
   * 操作与文件输入流操作一样
   */
  public static void read(byte[] src) throws IOException {
    // 选择流
    InputStream input = new BufferedInputStream(new ByteArrayInputStream(src));
    byte[] flush = new byte[1024];
    int len = 0;
    while (-1 != (len = input.read(flush))) {
      String str = new String(flush, 0, len);
      System.out.println(str);
    }
    input.close();
  }

}
