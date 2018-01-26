package com.ek.guide.zqiming.chapter1;

public class TestingValue {
	
	@SuppressWarnings("unused")
	public static void main(String args[]){
		float myValue=5.23f;
		double meValueTow=5.23;
		
		int two=2;
		int three=3;
		double result=0;
		//result=three/two+1.5=2.5,
		//看上去计算结果应该是3(3/2=1.5,+1.5=3)
		//这是因为two和three都是整形,得到的结果是1,1+1.5=2.5
		result=(double)three/two+1.5; 
		//类型强制转换,一个double和一个int计算,系统会自动把int强制转换为double
		System.out.println("计算结果"+result);
	}

}