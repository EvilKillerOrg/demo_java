package com.ek.guide.jvm;
/**
 * 类加载器的层次结构
 * 引导类加载器(加载核心库) BootstrapClassLoader
 * 扩展类加载器(加载扩展库) ExtClassLoader
 * 应用程序类加载器(加载应用类) AppClassLoader
 * 自定义类加载器
 * 
 * 类加载模式:
 * (代理模式 -- 双亲委托机制)
 * java -- 的代理模式是: 双亲委托机制(简单的说就是委托父类来加载)
 * (就是先向上传递到最高层引导类加载器,
 * 由引导类加载器判断是不是核心库的类是就加载不是就交给扩展类加载器,
 * 扩展类加载器再判断是不是载扩展库的类是就加载不是就交给应用程序类加载器,
 * 应用程序类加载器再去加载,当然还要判断是否要交给自定义类加载器来加载.)
 * 这样做就是为了安全(java安全机制),比如你自己定义一个java.lang.String 可以定义,
 * 但不会被加载 因为类只加载一次,引导类加载器已经加载了核心包里的String
 * 
 * tomcat -- 的代理模式和 双亲委托机制顺序相反 双亲委托机制安全但不够灵活
 * @author EK
 * @date 2017年8月1日
 */
public class Test1 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader()); //返回的是应用程序类加载器AppClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent()); //AppClassLoader的父类加载器 扩展类加载器ExtClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent()); //扩展类加载器的父类加载器引导类加载器是原生代码实现的java这获取不到
		
		
		System.out.println(System.getProperty("java.class.path"));
	}

}