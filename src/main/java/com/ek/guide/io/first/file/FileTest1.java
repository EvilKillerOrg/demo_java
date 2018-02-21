package com.ek.guide.io.first.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 取指定目录下的文件
 * @author EK
 * @date 2017年7月24日
 */
public class FileTest1 {

	public static void main(String[] ags) {

		// 构建一个文件目录对象
		File aDir = new File("C:\\Users\\ek\\Desktop\\test");

		// 目录是否存在 true=存在
		if (aDir.exists()) {
			System.out.println("当前目录存在");

			// 目录下的文件名数组
			String[] filenames = aDir.list();
			for (int i = 0; i < filenames.length; i++) {
				System.out.println(filenames[i] + " | ");
			}

			// 目录下文件对象数组
			File[] files = aDir.listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out
						.println("文件路径和名称: " + files[i].getParent() + files[i].getName() + 
								     " , 文件大小: " + files[i].length() + " B" +
										 " , 最后修改日期: "+dateFormat(new Date(files[i].lastModified())));
			}

		} else {
			System.out.println("桌面上没有 test 文件夹目录");
		}
	}
	
	public static String dateFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

}