package com.ek.guide.zqiming.chapter2;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class StaticMethodCall {

	public static void main(String[] args) {
		double radius = youInput(); //用来输入的方法
		double vm = computeVolume(radius); //用来计算的方法
		display(vm); //用来显示的方法
	}

	
	

	public static double youInput() {
		double result=0;
		String input = JOptionPane.showInputDialog("输入球的半径: ");
		result = Double.parseDouble(input);
		return result;
	}
	
	public static double computeVolume(double radius) {
		double volume=0;
		volume = 4.0/3*Math.PI*Math.pow(radius,3);
		return volume;
	}
	
	public static void display(double vm) {
		JOptionPane.showMessageDialog(null,"球的体积为: "+youNumberFormat(vm),"标题",JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static String youNumberFormat(double vm){
		DecimalFormat df = new DecimalFormat();
		return df.format(vm);
	}



}