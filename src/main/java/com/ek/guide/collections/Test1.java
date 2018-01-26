package com.ek.guide.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(1);
		list.add(2);
		
		Collections.sort(list); //集合排序
		System.out.println(list.toString());
	}

}