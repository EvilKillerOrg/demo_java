package com.ek.guide.io.second.demo04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符缓冲流(处理流)
 * 文件的读取和写出(文件拷贝)
 * 作用是提供缓冲
 * 用法是在节点流外面包一层: 缓冲流(字符流(File))
 */
public class CharBufferedStream {

  public static void main(String[] args) {
    File src = new File("src/main/java/com/ek/guide/io/second/demo04/CharBufferedStream1.java");
    File dest = new File("F:/Downloads/io/CharBufferedStream1.java");

    BufferedReader reader = null;  //使用父接口Reader的话没有readLine这个方法
    BufferedWriter writer = null;

    try {
      reader = new BufferedReader(new FileReader(src));
      writer = new BufferedWriter(new FileWriter(dest));
      String line = null;
      while (null != (line = reader.readLine())) {
        writer.write(line);
        writer.newLine(); // 换行
      }
      writer.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != writer) {
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
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
