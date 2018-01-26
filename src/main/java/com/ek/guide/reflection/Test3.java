package com.ek.guide.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * 通过反射API动态操作 构造器 方法 属性
 * @author EK
 * @date 2017年7月30日
 */
public class Test3 {
	public static void main(String[] args) {
		String path = "com.ek.guide.reflection.UserBean";
		
		try {
			Class<UserBean> clazz = (Class<UserBean>) Class.forName(path);
		
			//通过反射调用构造方法 , 构造对象
			UserBean user1 =  clazz.newInstance(); //使用无参构造方法
			System.out.println(user1);
			
			Constructor<UserBean> constructor = clazz.getDeclaredConstructor(String.class,int.class);
			UserBean user2 = constructor.newInstance("ek1",19);//使用有参的构造器
			System.out.println(user2.getUname());
			
			
			//通过反射调用方法
			UserBean user3 = clazz.newInstance();
			Method method = clazz.getMethod("setUname", String.class);
			method.invoke(user3, "ek2");
			System.out.println(user3.getUname());
			
			
			//通过反射操作属性
			UserBean user4 = clazz.newInstance();
			Field field = clazz.getDeclaredField("uname");
			field.setAccessible(true);//这个属性不用做访问安全检查,直接访问(否则会报错--私有属性不能访问)(还可以提高反射运行速度)
			field.set(user4, "ek3"); //通过反射直接写属性	
			System.out.println(user4.getUname()); //通过对象的方法调用的
			System.out.println(field.get(user4)); //通过反射调用的
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
}