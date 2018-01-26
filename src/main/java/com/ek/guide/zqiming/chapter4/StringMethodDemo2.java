package com.ek.guide.zqiming.chapter4;

public class StringMethodDemo2 {
	
	public static void main(String[] args) {
		
		String fullFileName = "MyDemo.java";
		int pos = fullFileName.indexOf(".");
		String fullname = fullFileName.substring(0, pos);
		String extension = fullFileName.substring(pos+1);
		String newFileName = fullname.concat("_backup");
		
		System.out.println(newFileName.concat(".").concat(extension));
	}

}