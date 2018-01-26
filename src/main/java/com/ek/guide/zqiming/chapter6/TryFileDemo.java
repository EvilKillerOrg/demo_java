package com.ek.guide.zqiming.chapter6;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TryFileDemo {
	
 
	public static void main(String[] args){
		
		
		//File aFile = new File("mytest.java"); 
		
		File aDir = new File("C:\\Users\\ek\\Desktop");
		
		if(aDir.exists()){ //exists()目录是否存在
			System.out.println("目录存在!");
			
			String[] filenames = aDir.list();//list()目录下的所有文件名数组
			for(int i=0; i<filenames.length; i++){
				System.out.println(filenames[i]+",");
			}
			
		
			System.out.println("-----------------------------------------------------");
			
			
			File[] files = aDir.listFiles();//listFiles()获得目录下对象数组
			for(int i=0; i<files.length; i++){
				System.out.println("目录: "+files[i].getParent()+",   "+
								   "名称: "+files[i].getName()+",   "+
								   "大小: "+files[i].length()+"B,   "+
								   "最后一次修改时间: "+dateFormat(new Date(files[i].lastModified())));
			}
		}
	}
	
	
	public static String dateFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

}