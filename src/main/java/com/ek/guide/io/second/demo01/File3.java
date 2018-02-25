package com.ek.guide.io.second.demo01;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 操作目录
 */
public class File3 {

  public static void main(String[] args) {
    // createDir();
    // viewDir();
    // viewFile();
    // viewTypeFile();
    File parentFile = new File("F:/Downloads");
    viewAllFile(parentFile);
  }

  /**------------<br>
   * 创建目录 
   */
  public static void createDir() {

    File file1 = new File("F:/Downloads/ppp/iotest");
    file1.mkdir(); // 创建目录(上一级父目录必须存在,否则创建不成功)

    File file2 = new File("F:/Downloads/ppp/iotest");
    file2.mkdirs(); // 创建目录(上一级父目录如果不存在,连父目录一起创建)
  }

  /**------------<br>
   * 输出当前目录下的子目录和文件
   */
  public static void viewDir() {
    File file1 = new File("F:/Downloads");
    if (file1.isDirectory()) { // 先判断这是不是一个目录
      String[] subNames = file1.list(); // 取所有的子目录和子文件
      for (String subName : subNames) {
        System.out.println(subName);
      }
    }
  }

  /**------------<br>
   * 输出当前目录下的子目录和文件的file对象
   */
  public static void viewFile() {
    File file1 = new File("F:/Downloads");
    if (file1.isDirectory()) {
      File[] subFiles = file1.listFiles();
      for (File subFile : subFiles) {
        System.out.println(subFile.getAbsolutePath());
      }
    }
  }

  /**------------<br>
   * 输出当前目录下的相同类型文件的file对象
   */
  public static void viewTypeFile() {
    File file1 = new File("F:/Downloads");
    if (file1.isDirectory()) {
      File[] subFiles = file1.listFiles(new FilenameFilter() { // 使用文件过滤器
        @Override
        public boolean accept(File file1, String name) { // dir就是file1
          return new File(file1, name).isFile() && name.endsWith(".txt");
        }
      });
      for (File subFile : subFiles) {
        System.out.println(subFile.getName());
      }
    }
  }

  /**------------<br>
   * 输出当前目录下的子孙目录和文件的file对象(递归就是自己调自己)
   */
  public static void viewAllFile(File file) {
    if (file.exists()) {
      System.out.println(file.getAbsolutePath());
    }
    if (file.isDirectory()) { // 文件夹
      for (File subFile : file.listFiles()) { // listFiles()获取当前目录下的所有子孙文件和目录
        viewAllFile(subFile); // 递归
      }
    }
  }

  /**------------<br>
   * 删除
   */
  public static boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();// 递归删除目录中的子目录下
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    // 目录此时为空，可以删除
    return dir.delete();
  }
}
