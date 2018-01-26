package com.ek.guide.zqiming.chapter6;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Employee extends Person implements Serializable{
	private int empno;
	private double salary;
	private Date hiredate;
	
	public Employee(){
		
	}
	
	public Employee(String name,int no,double s,int year,int month,int day){
		super(name);
		this.empno=no;
		this.salary=s;
		GregorianCalendar calendar =new GregorianCalendar(year,month-1,day);
		this.hiredate=calendar.getTime();
	}
	
	public String toString(){
		return super.toString()+
		"员工编号: "+this.empno+"\n"+
		"员工工资: "+this.salary+"\n"+
		"受雇日期: "+formatDate(this.hiredate)+"\n";
	}
	
	
	public static String formatDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	@Override
	public String getDescription() {
		return "Person类的子类";
	}
	 
	
}