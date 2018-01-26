package com.ek.guide.io.objectstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.ek.guide.io.objectstream.util.Employee;

public class ObjectOutputStreamTest {

	public static void main(String[] args) {

		Employee employee = new Employee("ek1", "292"); //待写入的对象
		String aFile = "employee.dat"; //写入的文件名
		File aDir = new File("C:\\Users\\ek\\Desktop\\mytest"); //写入文件的路径

		/*
		 * step 1 对象输出流
		 * 逻辑顺序是: 通过对象输出流把对象输出给文件输出流,再通过文件输出流输出文件(创建文件体)employee.dat
		 * 再writeObject(employee)把对象的内容写到创建的文件中
		 * 再close 
		 * 看下面这个明显:
		 * FileOutputStream fos = new FileOutputStream("c:/a.txt"); 
		 * ObjectOutputStream oos = new ObjectOutputStream(fos); 
		 * oos.writeObject(employee);
		 * oos.close();
		 * fos.close();
		 */
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(aDir, aFile), true);//这不用File对象也可以直接写路径,例如:new FileOutputStream("c:/a.txt"); 
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		/*
		 * step 2 将对象通过对象输出流写入文件中
		 */
		try {
			oos.writeObject(employee);
			System.out.println("成功将对象------------------->>>>\n\n " + employee.toString() + " 写入文件中\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("对象写入失败!");
		}

		
		/*
		 * step 3 关闭对象输出流
		 */
		try {
			oos.close();
			fos.close();
			System.out.println("对象输出流关闭!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}