package com.ek.guide.zqiming.chapter7;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		
		Student st1 = new Student("张三",001);
		Student st2 = new Student("李四",002);
		Student st3 = new Student("王五",003);
		
		//集合添加
		ArrayList list = new ArrayList();
		list.add(st1);
		list.add(st2);
		list.add(st3);
		
		
		//集合删除
		list.remove(st2);
		
		//迭代器  集合检索
		 Iterator itx = list.iterator();
		 while(itx.hasNext()){
			 Student stu = (Student)itx.next();//返回一个对象
			 System.out.println(stu.toString());
		 }
	}

}