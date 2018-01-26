package com.ek.guide.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解单例模式 (枚举破解不了) 
 * 防止反射破解,看SingletonStrongDemo的构造器
 * 防止反串行化,看SingletonStrongDemo的readResolve()方法
 * 
 * @author EK
 * @date 2017年7月26日
 */
public class Test2 {

	public static void main(String[] args) throws Exception {

		testSingleton();
		
		testReflect();
		
		testSerializable();

	}

	
	
	//懒汉单例
	public static void testSingleton(){
		SingletonStrongDemo s1 = SingletonStrongDemo.getInstance();
		SingletonStrongDemo s2 = SingletonStrongDemo.getInstance();
		System.out.println("单例模式创建的对象:");
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2 + "\n");
		
	}
	
	
	
	//用反射破解了单例模式
	public static void testReflect() throws Exception {
	
		Class<SingletonStrongDemo> clazz = (Class<SingletonStrongDemo>) Class.forName("com.ek.guide.designpattern1.singleton.SingletonStrongDemo");// Class.forName反射加载类

		Constructor<SingletonStrongDemo> c = clazz.getDeclaredConstructor(null);// 得到无参构造器

		c.setAccessible(true);// 跳过权限检查,没有这个会报错说私有的构造器 不能实例化

		SingletonStrongDemo s3 = c.newInstance();// 通过构造器实例化
		SingletonStrongDemo s4 = c.newInstance();// 通过构造器实例化

		System.out.println("反射破解了单例模式:");
		System.out.println("s3: " + s3);
		System.out.println("s4: " + s4 + "\n");
	}
	
	
	
	//用反串行化破解单例模式(反串行化返回来的会是一个新的对象)
	public static void testSerializable() throws Exception{
		
		SingletonStrongDemo s5 = SingletonStrongDemo.getInstance();
		
		//1. 先序列化(这里测试一下就没有try catch finally)
		//逻辑顺序是: 通过对象输出流把对象输出给文件输出流,再通过文件输出流输出文件(创建文件体)a.txt
		FileOutputStream fos = new FileOutputStream("c:/a.txt"); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(s5);//把对象的内容写到创建的文件中
		oos.close();
		fos.close();
		
		
		//2. 再反串行化
		FileInputStream fis = new FileInputStream("c:/a.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonStrongDemo s6 = (SingletonStrongDemo) ois.readObject();
		ois.close();
		fis.close();
		
		System.out.println("反串行化破解了单例模式:");
		System.out.println("s5: " + s5);
		System.out.println("s6: " + s6);
		
	}

}