package com.ek.guide.zqiming.chapter7;

import java.util.Stack;

public class StackDemo {
	
	//堆栈
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		
		Student st1 = new Student("张三",001);
		Student st2 = new Student("李四",002);
		Student st3 = new Student("王五",003);
		Student st4 = new Student("马六",004);
		Student st5 = new Student("赵七",005);
		
		Stack st = new Stack();//堆栈
		
		//向堆栈添加
		st.push(st1);
		st.push(st2);
		st.push(st3);
		st.push(st4);
		st.push(st5);
		
		//出栈
		 for(int i=0; i<3; i++){
			 Student stu = (Student)st.pop();
			 System.out.println(stu.toString());
		 }
		 
		 //堆栈中还剩下什么?
		 for(int i=0; i<st.size(); i++){
			 System.out.println("堆栈中剩余的东西: ");
			 System.out.println(st.get(i));
		 }
		
	}

}