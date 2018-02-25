package com.ek.guide.io.second.demo01;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件和删除文件
 * 还有下面这两个方法用来判断file是文件还是文件夹,实际工作中还要判断这个
 * file.isFile()
 * file.isDirectory()
 */
public class File2 {
  public static void main(String[] args) throws IOException {
    createFile();
    // deleteFile();
  }

  /**
   * 创建文件
   */
  public static void createFile() throws IOException {
    String path = "F:/Downloads/iotest.txt";
    File file = new File(path);
    if (!file.exists()) { // 文件是否已经存在
      boolean flag = file.createNewFile(); // 文件不存在则创建文件
      System.out.println(flag ? "创建文件成功" : "创建文件失败");
    } else {
      System.out.println("文件已经存在");
    }
  }

  /**
   * 删除文件
   */
  public static void deleteFile() {
    String path = "F:/Downloads/iotest.txt";
    File file = new File(path);
    if (file.exists()) { // 文件是否已经存在
      boolean flag = file.delete(); // 文件存在则删除文件
      System.out.println(flag ? "删除文件成功" : "删除文件失败");
    } else {
      System.out.println("文件已经不存在");
    }
  }

}
