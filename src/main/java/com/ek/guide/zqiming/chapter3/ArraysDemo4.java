package com.ek.guide.zqiming.chapter3;

public class ArraysDemo4 {

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
		
		//计算行的和与平均值
		int rowSum=0;//行的和
		int rowAverage=0;//行的平均值
		for(int i=0; i<numbers.length; i++){ //i代表行
			rowSum=0;//每开始计算新的一行时,把行的和清零
			for(int j=0; j<numbers[i].length; j++){
				rowSum+=numbers[i][j];
			}
			System.out.print("第 "+(i+1)+" 行的和为: "+rowSum);
			rowAverage = rowSum/numbers[i].length;
			System.out.println(" , 第 "+(i+1)+" 行的平均值为: "+rowAverage);
		}
		
		System.out.println();
		
		//计算列的和与平均值
		int colSum=0;//列的和
		int colAverage=0;//列的平均值
		for(int i=0; i<5; i++){ //i代表列
			colSum=0;
			for(int j=0; j<4; j++){
				colSum+=numbers[j][i];
			}
			System.out.print("第 "+(i+1)+" 列的和为: "+colSum);
			colAverage = colSum/4;
			System.out.println(" , 第 "+(i+1)+" 列的平均值为: "+colAverage);
		}
	}
}