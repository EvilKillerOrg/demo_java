package com.ek.guide.io.second.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 字符流(节点流)
 * 纯文本读取
 */
public class CharStream1 {

  public static void main(String[] args) {
    // 1.建立联系
    File file = new File("F:/Downloads/io/1.txt");
    // 2.选择流
    Reader reader = null;
    try {
      reader = new FileReader(file);
      // 3.读取
      char[] flush = new char[100];
      int len = 0;
      while (-1 != (len = reader.read(flush))) {
        String str = new String(flush, 0, len); // 字符数组转字符串
        System.out.println(str);// FileReader只能按系统默认的字符集来解码(可以把txt另存为UTF-8再读,或者先写出一次)
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 4.关闭
      if (null != reader) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
