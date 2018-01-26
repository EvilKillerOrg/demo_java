package com.ek.guide.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * 通过反射API动态获取 构造器 方法 属性
 * @author EK
 * @date 2017年7月30日
 */
public class Test2 {
	
	public static void main(String[] args) {
		String path = "com.ek.guide.reflection.UserBean";
		
		try {
			//加载类
			Class clazz = Class.forName(path);
			
			
			//获得类名
			System.out.println(clazz.getName()); //获得全类名
			System.out.println(clazz.getSimpleName()); //获得类名
			
			
			//获得属性信息
			Field aField = clazz.getDeclaredField("uname"); //获得指定名称的一个属性
			Field[] fields1 = clazz.getFields(); //获得所有public的属性
			Field[] fields2 = clazz.getDeclaredFields(); //获得所有属性
			for (Field field : fields2) {
				System.out.println("属性: "+field);
			}
			
			
			//获得方法
			Method aMethod1 = clazz.getDeclaredMethod("getUname", null); //获得指定方法
			Method aMethod2 = clazz.getDeclaredMethod("setUname", String.class); //获得指定方法
			Method[] methods1 = clazz.getMethods(); //获得所有公有方法
			Method[] methods2 = clazz.getDeclaredMethods(); //获得所有方法
			for (Method method : methods2) {
				System.out.println("方法:"+method);
			}
			
			
			//获得构造器信息
			Constructor aConstructor1 = clazz.getDeclaredConstructor(null); //获得指定构造器
			Constructor aConstructor2 = clazz.getDeclaredConstructor(String.class,int.class); //获得指定构造器
			Constructor[] constructors1 = clazz.getConstructors();//获得所有公有构造器
			Constructor[] constructors2 = clazz.getDeclaredConstructors();//获得所有构造器
			for (Constructor constructor : constructors2) {
				System.out.println("构造器:"+constructor);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}