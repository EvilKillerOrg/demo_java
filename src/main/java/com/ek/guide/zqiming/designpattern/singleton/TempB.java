package com.ek.guide.zqiming.designpattern.singleton;

public class TempB {
 
	private static TempB tempB = null;
	
	private TempB(){
		//private的构造方法 (不能被实例)
	}
	
	//想要得到这个对象的实例就要写下面这个方法
//	public static TempB newInstance(){
//		return new TempB(); //私有的构造方法 ,只能这个类本身可以调用
//	}
	
	//上面的方法改成这样就成立单例
	public static TempB newInstance(){
		if(tempB==null){
			tempB = new TempB();  
		}
		return tempB;
	}
	
}