package com.ek.guide.zqiming.chapter6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOperationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee emp = new Employee("张三",1057,3500.00,2017,02,15);
		
		String filename="employee.dat";
		
		
		
		/*
		 * step 1创建文件目录对象
		 */ 
		String dirname="C:\\Users\\ek\\Desktop\\mytest";
		File aDir = new File(dirname);
		if(!aDir.exists()){
			System.out.println("目录不存在,需要建立,处理中...");
			if(!aDir.mkdirs()){
				System.out.println("目录建立失败!");
				return;
			}else{
				System.out.println("目录建立成功!");
			}
		}else{
			System.out.println("目录存在!");
		}
		
		
		
		/*
		 * step 2 对象输出流(这里是物理创建了 目录和文件)
		 */
		
		
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(aDir,filename),true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*分开写是这样的 下面的 ObjectInputStream也是分开写的*/
//		File srcFile = new File(aDir,filename);
//		FileOutputStream fos=null;
//		ObjectOutputStream oos=null;
//		try {
//			fos = new FileOutputStream(srcFile,true);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			oos = new ObjectOutputStream(fos);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		 
		
		
		/*
		 * step 3 将对象通过对象输出流写入文件中
		 */
		try {
			oos.writeObject(emp);
			System.out.println("成功将对象------------------->>>>\n "+emp.toString()+"写入文件中\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("对象写入失败!");
		} 
		
		
		/*
		 * step 4 关闭对象输出流
		 */
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
		
		
		
		
		
		/*
		 * 从文件中通过对象输入流读取对象的信息!
		 */
		
		
		/*
		 * step 1 创建对象输入流
		 */
		File dstFile = new File(aDir,filename);
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis = new FileInputStream(dstFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * step 2读取信息
		 */
		int counter=0;
		 try {
			while(true){
				Employee otherEmp = (Employee)ois.readObject();
				counter++;
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx以下是从文件中读取到的信息!\n");
				System.out.println(otherEmp.toString());
			}
		} catch (EOFException e){//文件结束
			System.out.println("读取对象结束,共读取 "+counter+" 个对象");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		 
		/*
		 * step 3关闭对象输入流
		 */
		try {
			ois.close();
			System.out.println("对象输入流关闭!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}