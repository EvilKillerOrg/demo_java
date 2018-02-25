package com.ek.guide.io.second.demo02.filecopy;

import java.io.IOException;

/**
 * 拷贝文件
 */
public class FileCopy {

  public static void main(String[] args) {
    String srcPath = "F:/Downloads/1.png";
    String destPath = "F:/Downloads/100.png";
    
    try {
      FileCopyUtil.copyFile(srcPath, destPath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



}
