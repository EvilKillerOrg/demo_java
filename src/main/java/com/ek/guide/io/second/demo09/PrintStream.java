package com.ek.guide.io.second.demo09;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 打印流 输出流 字节流 处理流
 */
public class PrintStream {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("test");
    java.io.PrintStream ps = System.out;
    ps.println(false);

    File file = new File("F:/Downloads/io/print.txt");
    ps = new java.io.PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
    ps.print("print stream");
    ps.close();
  }
}