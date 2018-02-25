package com.ek.guide.io.second.demo02.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 功能: 
 * 1.文件拷贝
 * 2.文件夹拷贝(包括文件夹中的子孙文件夹和文件)
 */
public class FileCopyUtil {

  /**---------<br>
   * @Title: copyFile
   * @Description: 拷贝文件--这个方法传进来的参数是路径的字符串,把字符串处理成File对象再调用重载的copyFile(File...)
   * @param srcPath 源文件 type:String
   * @param destPath 目标文件 type:String
   * @throws FileNotFoundException
   * @throws IOException
   * @return: void
   */
  public static void copyFile(String srcPath, String destPath) throws FileNotFoundException, IOException {
    // 1.建立联系
    copyFile(new File(srcPath), new File(destPath));
  }

  /**---------<br>
   * @Title: copyFile
   * @Description: 重载拷贝文件方法
   * @param srcFile 源文件 type:File 
   * @param destFile 目标文件 type:File 
   * @throws FileNotFoundException
   * @throws IOException
   * @return: void
   */
  public static void copyFile(File srcFile, File destFile) throws FileNotFoundException, IOException {
    // 判断src file对象是文件还是目录
    if (srcFile.isDirectory()) {
      throw new IOException("只能拷贝文件!");
    }
    
    //判断destFile为已经存在的文件夹,不能创建与已经存在的文件夹同名的文件
    if(destFile.isDirectory()){ 
      throw new IOException("不能创建与已经存在的文件夹同名的文件!");
    }
    // 2.选择流
    InputStream in = new FileInputStream(srcFile);
    OutputStream out = new FileOutputStream(destFile);

    // 3.文件拷贝
    byte[] flush = new byte[1024];
    int len = 0;
    // 3.1读取
    while (-1 != (len = in.read(flush))) {
      // 3.2写出
      out.write(flush, 0, len);
    }
    out.flush(); // 强制刷出

    // 4.关闭流
    out.close();
    in.close();
  }

  /**---------<br>
   * @Title: copyDir
   * @Description: 拷贝文件夹--这个方法传进来的参数是路径的字符串,把字符串处理成File对象再调用重载的copyDir(File...)
   * @param srcPath 源 type:String
   * @param destPath 目标 type:String
   * @throws FileNotFoundException
   * @throws IOException
   * @return: void
   */
  public static void copyDir(String srcPath, String destPath) throws FileNotFoundException, IOException {
    copyDir(new File(srcPath), new File(destPath));
  }

  /**---------<br>
   * @Title: copyDir
   * @Description: 重载拷贝文件夹方法
   * @param srcFile 源 type:File 
   * @param destFile 目标 type:File 
   * @throws FileNotFoundException
   * @throws IOException
   * @return: void
   */
  public static void copyDir(File srcFile, File destFile) throws FileNotFoundException, IOException {
    if (srcFile.isDirectory()) { // 如果是文件夹 构建文件的File对象
      destFile = new File(destFile, srcFile.getName());
    }
    copyDirDetail(srcFile, destFile);
  }

  /**---------<br>
   * @Title: copyDirDetail
   * @Description: 拷贝文件夹细节(包括子孙目录和文件)
   * @param srcFile
   * @param destFile
   * @throws FileNotFoundException
   * @throws IOException
   * @return: void
   */
  public static void copyDirDetail(File srcFile, File destFile) throws FileNotFoundException, IOException {
    if (srcFile.isFile()) { // 如果是文件就拷贝
      copyFile(srcFile, destFile);
    } else if (srcFile.isDirectory()) { // 如果是文件夹就创建文件夹
      destFile.mkdirs();
      for (File subSrcFile : srcFile.listFiles()) {
        copyDirDetail(subSrcFile, new File(destFile, subSrcFile.getName()));
      }
    }
  }

}
