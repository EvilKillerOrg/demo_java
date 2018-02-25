package com.ek.guide.io.second.demo01;

import java.io.File;

/**
 * File 是路径和文件名 
 */
public class File1 {
  public static void main(String[] args) {

    /* 分隔符 */
    System.out.println(File.pathSeparator); // 1.路径分隔符--> ;
    System.out.println(File.separator); // 2.名称分隔符--> \(Windows), /(Linux)

    /* 构建路径的形式 */
    String path = "F:\\Temp\\IOTest\\2.jpg"; // 这种不推荐
    path = "F:" + File.separator + "Temp" + File.separator + "IOTest" + File.separator + "2.jpg"; // 也不推荐这样写,具有操作系统兼容性,跨平台
    path = "F:/Temp/IOTest/2.jpg"; // 推荐的是这种

    /* 使用相对路径和绝对路径构建文件 */
    File file1 = new File("F:/Temp/IOTest/2.jpg"); // 绝对路径构建
    System.out.println("file1-->" + file1.getPath());

    String parentPath = "F:/Temp/IOTest";
    String name = "2.jpg";
    File file2 = new File(parentPath, name); // 相对路径构建
    System.out.println("file2-->" + file2.getPath());

    File file3 = new File("2.jpg"); // 不指定盘符的相对路径构建
    System.out.println("file3-->" + file3.getAbsolutePath());

    File file4 = new File("."); // 通常用这种方式获取相对当前路径的绝对路径
    System.out.println("file4-->" + file4.getAbsolutePath());
  } 
}
