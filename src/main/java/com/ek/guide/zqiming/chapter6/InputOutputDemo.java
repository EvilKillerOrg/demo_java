package com.ek.guide.zqiming.chapter6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class InputOutputDemo {
	
	
	/**
	 * 笨办法,适合学生教课的方法,一般常用的是串行化 
	 */
	
	public static void main(String[] args){
		
		String demo = "this is my first java programming for writing string files.";
		
		String aFile = "mystr.txt";
		File aDir = new File("C:\\Users\\ek\\Desktop\\mytest");
		
		
		/*
		 * 1创建文件目录
		 */
		if(!aDir.exists()){//目录是否存在
			System.out.println("目录不存在,需要建立,处理中...");
			if(!aDir.mkdirs()){//建立目录 //一级目录用mkdir()
				System.out.println("目录建立失败!");
				return;
			}else{
				System.out.println("目录建立成功!");
			}
		}else{
			System.out.println("目录存在!");
		}
		
		
		/*
		 * 2创建文件输出流
		 */
		//FileOutputStream可以物理的建立目录和文件,可以指定建立方式为追加
		//File对象只是封装了一个目录和文件名的信息
		FileOutputStream outputFile=null;
		try {
			outputFile = new FileOutputStream(new File(aDir,aFile),true);//true表示以追加的形式
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 3建立文件通道对象
		 */
		FileChannel outChannel = outputFile.getChannel();
		
		
		/*
		 * 4创建缓冲区对象,并将需要写入文件的数据装载到缓冲区中
		 */
		ByteBuffer buf = ByteBuffer.allocate(1024);
		for(int i=0; i<demo.length(); i++){
			buf.putChar(demo.charAt(i));
		}
		buf.flip();//缓冲区翻转
		
		
		/*
		 * 5将信息写入文件中
		 */
		try {
			outChannel.write(buf);
			System.out.println("写入文件成功!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("写入文件异常!");
		}finally{
			try {
				outChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outputFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}