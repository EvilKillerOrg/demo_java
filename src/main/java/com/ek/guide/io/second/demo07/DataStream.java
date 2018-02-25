package com.ek.guide.io.second.demo07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型(基本数据类型+String)处理流
 */
public class DataStream {

  public static void main(String[] args) throws IOException {
    // writer("F:/Downloads/io/data.txt");
    reader("F:/Downloads/io/data.txt");
  }

  /**---------<br>
   * @Title: reader
   * @Description: 从文件读取数据+类型
   * @param destPath
   * @throws IOException
   * @return: void
   */
  public static void reader(String destPath) throws IOException {
    // 创建源
    File dest = new File(destPath);
    DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(dest)));

    // 操作 读取数据的顺序和输出的顺序要一致,且必须存在的才能读取
    double point = input.readDouble();
    long num = input.readLong();
    String str = input.readUTF();

    System.out.println(point + "--" + num + "--" + str);
    input.close();
  }

  /**---------<br>
   * @Title: writer
   * @Description: 数据+类型输出到文件
   * @param destPath
   * @throws IOException
   * @return: void
   */
  public static void writer(String destPath) throws IOException {
    double point = 2.5;
    long num = 100L;
    String str = "数据类型";

    // 创建源
    File dest = new File(destPath);
    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
    // 操作 注意写出的顺序 为读取做准备 要和读取的顺序一致
    out.writeDouble(point);
    out.writeLong(num);
    out.writeUTF(str);

    out.flush();
    out.close();
  }
}
