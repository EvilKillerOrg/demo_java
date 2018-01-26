package com.ek.guide.recursion.demo1;

/**
 * 测试 递归 自己调用自己(会死循环,必须有出口)
 * 耗时耗空间
 * @author EK
 * @date 2017年7月30日
 */
public class Test1 {
	private static int i = 0;
	public static void test01() {
		i++;
		System.out.println("test01: "+i);
		if(i<=10){
			test01();
		}else{
			System.out.println("over");
		}
		
	}
	
	
	
	public static int factorial(int n){
		 if(n==1){
			 return 1;
		 }else{
			 return n*factorial(n-1);
		 }
	}

	public static void main(String[] args) {
		//test01();
		System.out.println(factorial(5));
	}

}