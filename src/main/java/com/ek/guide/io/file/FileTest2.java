package com.ek.guide.io.file;

import java.io.File;
import java.io.IOException;
/**
 * 创建一个目录
 * @author EK
 * @date 2017年7月25日
 */
public class FileTest2 {
	public static void main(String[] args){
		
		String filename ="myetest.java"; //声明一个文件名
		File aDir = new File("C:\\Users\\ek\\Desktop\\mytest"); //构建一个目录
		File aFile = new File(aDir , filename); //构建要创建的文件
		
		
		//目录不存在则新建目录
		if(!aDir.exists()){
			if(!aDir.mkdirs()){//建立目录 一级目录用mkdir()
				System.out.println("目录创建失败");
				return;
			}else{
				System.out.println("目录创建成功");
				try {
					aFile.createNewFile();//创建文件
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("目录已经存在");
		}
		
	}

}