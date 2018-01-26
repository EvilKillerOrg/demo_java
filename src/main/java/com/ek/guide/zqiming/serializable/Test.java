package com.ek.guide.zqiming.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test {

	public static void main(String[] args) {
		 
//		UserInfo user = new UserInfo();
//		user.setUsername("ek");
//		user.setPassword("123");
//		
//		
//		System.out.println(user);//把这个对象的地址打印到控制台
//		
//		
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(System.out);
//			oos.writeObject(user); //把对象的字节码内容打印到控制台 , 这个对象的字节码可以翻转回来成一个对象
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
//		try {
//			 fos = new FileOutputStream(new File("c:/t.tmp"));//创建文件
//			 oos = new ObjectOutputStream(fos); //把对象写到一个文件中 这就叫串行化
//			 oos.writeObject(user);//写入
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			 fis = new FileInputStream("c:/t.tmp");//读文件
			 ois = new ObjectInputStream(fis);//反串行化
			 UserInfo user = (UserInfo) ois.readObject();
			 System.out.println("username: "+user.getUsername());//读出
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}