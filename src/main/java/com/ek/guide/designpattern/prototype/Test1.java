package com.ek.guide.designpattern.prototype;

import java.util.Date;

/**
 * 测试原型模式
 * 浅克隆
 * 1. 以s1为原型 通过s1.clone()克隆一个一样的对象 
 * 2. 克隆的这个对象的属性指向的引用也一样			
 * 3. 这个对象可以在这里改变
 * @author EK
 * @date 2017年7月28日
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		
		cloneS1();
		cloneAndChangeS1();
	}
	
	
	public static void cloneS1() throws Exception{
		 Sheep s1 = new Sheep("多利", new Date(234353222543L));
		 Sheep s2 = (Sheep) s1.clone();
		 
		 System.out.println(s1);
		 System.out.println(s2 +" \n");
		 
		 
		 System.out.println("sname: "+s1.getSname()+" birthday: "+s1.getBirthday());
		 System.out.println("sname: "+s2.getSname()+" birthday: "+s2.getBirthday()+" \n");
		 
		 System.out.println("s1 s2对象不一样,但是值完全一样"+" \n \n \n");
	}
	
	
	
	public static void cloneAndChangeS1() throws Exception{
		 Sheep s1 = new Sheep("多利", new Date(234353222543L));
		 Sheep s2 = (Sheep) s1.clone();
		 s2.setSname("多小利");
		 
		 
		 System.out.println(s1);
		 System.out.println(s2 +" \n");
		 
		 
		 System.out.println("sname: "+s1.getSname()+" birthday: "+s1.getBirthday());
		 System.out.println("sname: "+s2.getSname()+" birthday: "+s2.getBirthday()+" \n");
		 
		 System.out.println("s1 s2对象不一样,值可以改变");
	}
	
	
}