package com.ek.guide.zqiming.chapter7;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args){
		
		Student st1 = new Student("张三",001);
		Student st2 = new Student("李四",002);
		Student st3 = new Student("王五",003);
		Student st4 = new Student("马六",004);
		Student st5 = new Student("赵七",005);
		
		Vector vt = new Vector();
		vt.addElement(st1);
		vt.add(0,st2);
		vt.add(st3);
		
		
		vt.removeElement(2);//移除

		
		Iterator itx = vt.iterator();
		while(itx.hasNext()){
			Student sut = (Student)itx.next();
			System.out.println(sut.toString());
		}
		
		vt.firstElement();//取第0个
		vt.lastElement();//取最后一个
		vt.indexOf(st3);//第几个
		vt.contains(st5);//包含
	}
		
	
		

}