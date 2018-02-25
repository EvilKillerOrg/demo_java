package com.ek.guide.io.second.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 只能复制文本文件
 */
public class FileCopyOnlyChar {

  public static void main(String[] args) {

    File src = new File("src/main/java/com/ek/guide/io/second/demo03/FileCopyOnlyChar.java");
    File dest = new File("F:/Downloads/io",src.getName());

    Reader reader = null;
    Writer writer = null;

    try {
      reader = new FileReader(src);
      writer = new FileWriter(dest);
      char[] flush = new char[1024];
      int len = 0;
      while (-1 != (len = reader.read(flush))) {
        writer.write(flush, 0, len);
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