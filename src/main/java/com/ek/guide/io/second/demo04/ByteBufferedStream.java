package com.ek.guide.io.second.demo04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节缓冲流(处理流)
 * 文件的读取和写出(文件拷贝)
 * 作用是提供缓冲
 * 用法是在节点流外面包一层: 缓冲流(字节流(File))
 */
public class ByteBufferedStream {

  public static void main(String[] args) {
    File src = new File("src/main/java/com/ek/guide/io/second/demo04/ByteBufferedStream1.java");
    File dest = new File("F:/Downloads/io/ByteBufferedStream1.java");
    
    InputStream input = null; //字节缓冲流没有readLine这个方法
    OutputStream out = null;
    
    try {
      input= new BufferedInputStream(new FileInputStream(src));
      out = new BufferedOutputStream(new FileOutputStream(dest));
      byte[] fulsh = new byte[1024];
      int len =0;
      while(-1!=(len = input.read(fulsh))){
        out.write(fulsh, 0, len);
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally{
      if(null!=out){
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if(null!=input){
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
