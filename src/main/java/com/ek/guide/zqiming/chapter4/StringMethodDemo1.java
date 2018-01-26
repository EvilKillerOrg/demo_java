package com.ek.guide.zqiming.chapter4;

public class StringMethodDemo1 {

	public static void main(String[] args) {
		String temp = "This is an example for testing object of string.";
		for(int i=0; i<temp.length(); i++){
			char ch = temp.charAt(i); //字符的位置
			System.out.print(ch+"|");
		}
		System.out.println();
		
		//String 常用的方法
		temp.length();//长度
		temp.compareTo("");//比较
		temp.compareToIgnoreCase("");//忽略大小写的比较
		temp.concat("");//用来连接的 与 + 类似
		temp.startsWith("");//用来判断是否由什么开始
		temp.endsWith("");//用来判断是否由什么结束
		temp.equals("");//比较内容;
		temp.equalsIgnoreCase("");//忽略大小写的比较内容
		temp.getBytes();//获得字节数组
		//temp.getChars(srcBegin, srcEnd, dst, dstBegin);//得到从哪开始到哪结束的字符数组
		temp.indexOf(1);//从什么位置开始 
		temp.indexOf("is");//得到位置 
		temp.substring(0);
	}

}