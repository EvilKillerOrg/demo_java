package com.ek.guide.io.second.demo02.filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 拷贝文件夹
 */
public class DirCopy {

  public static void main(String[] args) {
    String srcPath = "F:/Downloads/io";
    String destPath = "F:/Downloads/io2";

    try {
      FileCopyUtil.copyDir(srcPath, destPath);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
     
    
  }

 
 
  

}
