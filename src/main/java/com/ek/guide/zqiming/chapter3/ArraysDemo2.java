package com.ek.guide.zqiming.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraysDemo2 {
	
	public static void main(String args[]){
		//求最大元素和下标
		int[] numbers = {91,78,29,21,35,47,85,64,5000,123,321,88};
		int position=0;
		int maxElement=numbers[0];
		//假设数组的第一个元素numbers[0]为最大值,然后循环比较,如果有更大的就赋值给maxElement
		for(int i=1; i<numbers.length; i++){
			if(maxElement<numbers[i]){
				maxElement=numbers[i];
				position=i;
			}
		}
		System.out.println("最大值: "+maxElement+" ,下标: ["+position+"]");
		
		
		
		//对数组升序排序
		Arrays.sort(numbers);
		for(int i=1; i<numbers.length; i++){
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
		
		
		
		//对用户输入的数字进行查找,如果数组中存在这个数字,输出其下标
		String valueVal ="";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入数字: ");
		try {
			valueVal = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int key = Integer.parseInt(valueVal);
		int pos = Arrays.binarySearch(numbers,key); 
		//找到了返回下标,找不到返回-1
		if(pos>=0){
			System.out.println("找到了: "+key+" 是数组中第 "+pos+" 个元素");
		}else{
			System.out.println("没有的!");
		}
		
	}

}