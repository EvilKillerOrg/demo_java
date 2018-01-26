package com.ek.guide.zqiming.chapter5;

public class FinalDemo {

	@SuppressWarnings("unused")
	private static  final   double result=0;;
	
	private double ii;
	private double jj;
	
	
	@SuppressWarnings("unused")
	public  void main(String  args) {
		int i =50; 
		int j= 30;
		
	//	result = i+j; 
	}
	
	
	
	
	//final 的方法可以重载
	public static double add(){
		FinalDemo f = new FinalDemo();
		return  f.ii+f.jj;
	}
	public final void add(int i){
	}
	
	 

}