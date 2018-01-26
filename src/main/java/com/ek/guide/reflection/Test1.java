package com.ek.guide.reflection;
/**
 * 反射
 * 获取Class对象
 * @author EK
 * @date 2017年7月30日
 */
public class Test1 {
	
	public static void main(String[] args) {
		
		try {
			getClass1();
			getClass2();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//获取Class对象的方式
	public static void getClass1() throws ClassNotFoundException{
		String path = "com.ek.guide.reflection.UserBean";
		
		/* 一个类被加载后,jvm会创建一个对应该类的Class对象,类的整个结构信息会放在这个Class对象中.
	   这个Class对象中可以看到这个类的所有属性和方法 */
		Class<?> clazz = Class.forName(path); //动态加载一个类
		System.out.println(clazz);
		
		Class<?> strClass1 = String.class; //通过.class获取Class对象
		System.out.println(strClass1);
		
		Class<?> strClass2 = path.getClass(); //通过.getclass()方法获取Class对象
		System.out.println(strClass2);
		
		Class<?> intClass = int.class; //获得基本数据类型的Calss对象
		System.out.println(intClass);
		
		int[] arr01 = new int[10];
		int[][] arr02 = new int[10][10];
		Class<?> arrClass1 = arr01.getClass(); //获取数组的Class对象
		Class<?> arrClass2 = arr02.getClass();
		System.out.println(arrClass1);
		System.out.println(arrClass2);
		
		System.out.println("\n");
	}
	
	
	
	
	
	//相同类型的Class对象只有一个 或者说相同类型的Class对象是同一个
	public static void getClass2() throws ClassNotFoundException{
		String str = "Hello World!!";
		
		Class<?> strClass1 = String.class;  
		Class<?> strClass2 = str.getClass();
		System.out.println(strClass1.hashCode()==strClass2.hashCode());
		
		 
		// 相同维度的数组是同一个Class对象
		int[] arr01 = new int[10];
		int[][] arr02 = new int[10][10];
		int[] arr03 = new int[30];
		Class<?> arrClass1 = arr01.getClass(); 
		Class<?> arrClass2 = arr02.getClass();
		Class<?> arrClass3 = arr03.getClass();
		System.out.println(arrClass1.hashCode());
		System.out.println(arrClass2.hashCode());
		System.out.println(arrClass3.hashCode());
	}

}