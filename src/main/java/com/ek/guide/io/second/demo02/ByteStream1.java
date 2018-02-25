package com.ek.guide.io.second.demo02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流(节点流)
 * 文件的读取
 */
public class ByteStream1 {

  public static void main(String[] args) {
    // 1.建立联系
    File file = new File("F:/Downloads/a.txt");
    // 2.选择流
    InputStream input = null;
    try {
      input = new FileInputStream(file);
      // 3.操作(不断的读取)
      byte[] car = new byte[10]; // 缓冲数组
      int len = 0; // 接收实际读取的大小
      while (-1 != (len = input.read(car))) { // 循环读取
        // 输出 (字节数组转成字符串)
        String info = new String(car, 0, len); // 字节数组转字符串(字节数组,从哪开始,到哪结束)
        System.out.println(info);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("文件不存在");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("读取失败");
    } finally {
      // 4.释放资源
      if (null != input) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
          System.out.println("关闭文件输入流失败");
        }
      }
    }
  }

}
