package com.ek.guide.io.objectstream;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.ek.guide.io.objectstream.util.Employee;

 

public class ObjectInputStreamTest {

	public static void main(String[] args) {
		String filename = "employee.dat";
		File aDir = new File("C:\\Users\\ek\\Desktop\\mytest");

		/*
		 * step 1 创建对象输入流 
		 * 这个输出流是反的 看看输出流就明白了
		 */
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(aDir, filename)); //这不用File对象也可以直接写路径,例如:new FileInputStream("c:/a.txt");
			ois = new ObjectInputStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * step 2读取信息
		 */
		int counter = 0;
		try {
			while (true) {
				Employee otherEmp = (Employee) ois.readObject();//读入对象
				counter++;
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx以下是从文件中读取到的信息!\n");
				System.out.println(otherEmp.toString());
			}
		} catch (EOFException e) {// 文件结束
			System.out.println("读取对象结束,共读取 " + counter + " 个对象");
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
			fis.close();
			System.out.println("对象输入流关闭!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}