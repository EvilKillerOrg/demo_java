package com.ek.guide.zqiming.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class TestReflect {
//反射机制
	
 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		/**
		 * java类运行的过程:
		 *   java源文件编译成class(字节码) ,
		 *   class被加载到虚拟机内存中 
		 *   虚拟机把class转换成机器语言(二进制)
		 */

		
		/**
		 * 获得反射对象的一种方式
		 */
//		Class testReflectVO1 = TestReflectVO.class; 
//		System.out.println(testReflectVO1+"-----------");
		
		
		
		/**
		 * 获得反射对象的二种方式
		 * Class.forName(..)把指定的类 由字节码文件加载到虚拟机中去 ,返回一个Class
		 */
		try {

//-------获得反射对象--------------------------------------------------------------------------------------------------------------------------------------//

			Class testReflectVO = Class.forName("com.ek.guide.jdk.reflect.TestReflectVO");
		
//-------获得类名和包名------------------------------------------------------------------------------------------------------------------------------------//
			System.out.println(testReflectVO.getSimpleName()); //只获得类名
			System.out.println(testReflectVO.getName()); //获得的是包名和类名
		
//-------获得公有属性--------------------------------------------------------------------------------------------------------------------------------------//

//			Field[] publicFields = testReflectVO1.getFields(); //获得类中的public属性(java bean 属性应该是私有的)
//			for (Field publicField : publicFields) {
//				System.out.println("public-- "+publicField.getName()); //获得属性名称
//			}

//-------获得所有属性--------------------------------------------------------------------------------------------------------------------------------------//

//			Field[] Fields = testReflectVO.getDeclaredFields(); //获得类中的所有属性
//			for (Field field : Fields) {
//				System.out.print(field.getName()+" -- "); //获得属性名称
//				System.out.println(field.getType()); //获得属性类型
//			}
			
//-------获得公有方法--------------------------------------------------------------------------------------------------------------------------------------//

//			Method[] publicMethods = testReflectVO.getMethods(); //获得类中的public方法(包括父类的方法,<所有的java类继承Object类>)
//			for (Method publicMethod : publicMethods) {
//				System.out.println(publicMethod.getName()) ;//获得方法名称
//			}
			
//-------获得构造方法&实例&方法&调用方法---------------------------------------------------------------------------------------------------------------//

//			Object obj = testReflectVO.newInstance(); //通过反射对象获得类的一个实例(这个只适合于无参的构造方法)
//			Constructor[] constructors = testReflectVO.getConstructors(); //获得所有的构造方法
			Object object =testReflectVO.getConstructor(String.class , Date.class).newInstance("abc" , new Date()); //获得指定参数的构造方法,再来实例化,newInstance的不定长参数(Object...)是给构造方法传参
			
//			Method setUsernameMethod = testReflectVO.getMethod("setUsername", String.class); //获得set方法
//			setUsernameMethod.invoke(object, "ek");//调用方法  (调用set方法后打印的就是ek,不调用set方法打印的是实例化时传的初始值)
			
			Method getUsernameMethod = testReflectVO.getMethod("getUsername"); //获得某个方法 第一个参数是方法名 ,后面是不定长参数(Class...)给方法传参用的,无参给null(可以不写)
			Object returnValue = getUsernameMethod.invoke(object); //调用方法 第一个参数是调用哪一个对象的这个方法,后面是不定长参数(Object...))给方法传参用的,无参给null(可以不写)
			System.out.println(object);
			System.out.println(returnValue);
			
//----------------------------------------------------------------------------------------------------------------------------------------------------------//
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}