package com.ek.guide.zqiming.chapter3;

public class ArraysDemo3 {
	
	public static void main(String args[]){
		int numbers[][] = new int[4][5];
		int k=1;
		//双层循环,第一次循环到每一行的时候,在第二层循环给每一列赋值
		for(int i=0; i<numbers.length; i++){
			for(int j=0; j<numbers[i].length; j++){
				numbers[i][j]=k;
				k++;
			}
		}
		displayArraysInfo(numbers);
	}
	
	//显示二维数组
	public static void displayArraysInfo(int arrays[][]){
		for(int i=0; i<arrays.length; i++){
			for(int j=0; j<arrays[i].length; j++){
				System.out.print(arrays[i][j]+"\t");
			}
			System.out.println();
		}
	}

}