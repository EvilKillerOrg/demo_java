package com.ek.guide.io.second.demo02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节流(节点流)
 * 写出文件
 */
public class ByteStream2 {

  public static void main(String[] args) {
    // 1.建立联系
    File file = new File("F:/Downloads/b.txt");
    // 2.选择流
    OutputStream out = null;
    try {
      out = new FileOutputStream(file, true); // true是追加写,false是覆盖
      // 操作
      String str = "hahaha \r\n";
      byte[] data = str.getBytes(); // 字符串转字节数组
      out.write(data, 0, data.length);
      out.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != out) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
