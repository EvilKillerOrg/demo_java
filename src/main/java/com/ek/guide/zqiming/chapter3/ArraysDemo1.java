package com.ek.guide.zqiming.chapter3;

public class ArraysDemo1 {
	
	@SuppressWarnings("unused")
	public static void main(String args[]){
		int[] numbers = {21,35,47,85,64};
		int[] arrays = new int[10];
		int k =1;
		for(int i=0; i<10; i++){
			arrays[i]=k;
			k++;
		}
		
		int sum=0;
		double average=0;
		for(int i=0; i<arrays.length; i++){
			sum+=arrays[i];
		}
		
		average = sum/arrays.length;
		
		System.out.println("sum=: "+sum);
		System.out.println("average=: "+average);
		
	}
	
}
