package com.ek.guide.arrays;

import java.util.Arrays;
/**
 * Arrays 是操作数组的
 * Collections 是操作集合的
 * @author EK
 * @date 2017年7月30日
 */
public class Test1 {

	public static void main(String[] args) {
		int[] a = {5,6,2};
		Arrays.sort(a); //数组排序
		System.out.println(Arrays.toString(a));
		
		//将一个数组转化为一个List对象，这个方法会返回一个ArrayList类型的对象， 这个ArrayList类并非java.util.ArrayList类，而是Arrays类的静态内部类！
		Arrays.asList(a);
		
	}

}