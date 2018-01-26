package com.ek.guide.zqiming.designpattern.singleton;

public class Test {

	//单例模式 就是指只能有一个实例 比如DBUtil 就可以设计成单例模式
	
	public static void main(String[] args) {
		
		TempA a = new TempA();
		TempA a2 = new TempA();
		if(a==a2){
			System.out.println("a==a2 , 是同一个实例");
		}else{
			System.out.println("a<>a2 , 不是同一个实例");
		}
		
		//TempB 是private的构造方法 这里不能 new了 , 要调用TempB内部写的方法来实例化
		//TempB b= new TempB(); 
		TempB b = TempB.newInstance();
		TempB b2 =TempB.newInstance();
		if(b==b2){
			System.out.println("b==b2 , 是同一个实例");
		}else{
			System.out.println("b<>b2 , 不是同一个实例");
		}
		
	}

}