package com.ek.guide.io.first.filestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 1.FileOutputStream 创建指定目录下的文件
 * 2.写入文件
 * @author EK
 * @date 2017年7月25日
 */
public class FileOutputStreamTest {

	public static void main(String[] args) {

		String demo = "this is my first java programming for writing string files.";
		String aFile = "mystr.txt";
		File aDir = new File("C:\\Users\\ek\\Desktop\\mytest");

		/*
		 * 1.文件输出流创建文件,(但不会创建目录创建目录用File对象)
		 */
		FileOutputStream outFile = null;
		try {
			//outFile = new FileOutputStream(new File("C:\\Users\\ek\\Desktop\\mytest\\myetest.java"), true);// 这样写也可以
			outFile = new FileOutputStream(new File(aDir, aFile), true);// true表示以追加的形式
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 2.1建立文件通道对象
		 */
		FileChannel outChannel = outFile.getChannel();
		/*
		 * 2.2创建缓冲区对象,并将需要写入文件的数据装载到缓冲区中
		 */
		ByteBuffer buf = ByteBuffer.allocate(1024);
		for (int i = 0; i < demo.length(); i++) {
			buf.putChar(demo.charAt(i));
		}
		buf.flip();// 缓冲区翻转
		/*
		 * 2.3将信息写入文件中
		 */
		try {
			outChannel.write(buf);
			System.out.println("写入文件成功!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("写入文件异常!");
		} finally {
			try {
				outChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}