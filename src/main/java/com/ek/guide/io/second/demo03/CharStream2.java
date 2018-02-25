package com.ek.guide.io.second.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符流(节点流)
 * 写出文本
 */
public class CharStream2 {

  public static void main(String[] args) {
    // 1.建立联系
    File file = new File("F:/Downloads/io/1.txt");
    // 2.选择流
    Writer writer = null;
    try {
      writer = new FileWriter(file,true);
      // 3.操作
      String str = "\r\n我日了!";  
      writer.write(str); // 可以不用转字符数组直接给字符串(也可以传字符数组)
      writer.append("呀呀呀"); // 还可以用append 追加字符序列
      writer.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }finally{
   // 4.关闭
      if(null!=writer){
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
