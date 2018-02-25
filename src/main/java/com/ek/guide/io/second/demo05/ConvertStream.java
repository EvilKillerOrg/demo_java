package com.ek.guide.io.second.demo05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流(处理流) --> 字节专为字符
 * 输出流: OutputStreamWriter 编码
 * 输入流: InputStreamReader 解码
 * 这两个类就是 字节流的名字加上字符流的名字
 * 用法是在外面再包一层: 缓冲流(转换流(字节流(File),"charset"))--转换流里只能包字节流才能设置字符集
 */
public class ConvertStream {

  public static void main(String[] args) throws IOException {
    File src = new File("F:/Downloads/io/3.txt");
    File dest = new File("F:/Downloads/io/4.txt");

    BufferedReader reader = new BufferedReader (new InputStreamReader(new FileInputStream(src),"GBK"));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest),"GBK"));
    String str = null;
    while(null!=(str=reader.readLine())){
      writer.write(str);
    }
    writer.flush();
    reader.close();
  }
}
