package com.ek.guide.zqiming.chapter3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {
	
	
	public static void main(String[] args) {
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(currentDate);
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);	
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		//构造一个日期
		GregorianCalendar userCalendar = new GregorianCalendar(2017,3,11);
		Date youDate = userCalendar.getTime();
		System.out.println(sdf.format(youDate));
	}
	
	

}