package com.ek.guide.zqiming.chapter1;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class ComputeInterest {
	
	public static void main(String args[]){
		String benjinVal = JOptionPane.showInputDialog("请输入本金:");
		String nianxianVal = JOptionPane.showInputDialog("请输入存款年限:");
		String rateVal = JOptionPane.showInputDialog("请输入存款利率");
		
		double result=0;
		
		double benjin = Double.parseDouble(benjinVal);
		double xianxian = Double.parseDouble(nianxianVal);
		double rate = Double.parseDouble(rateVal);
		
		result=benjin*Math.pow(1+rate, xianxian);
		DecimalFormat df = new DecimalFormat("0.00");
		
		JOptionPane.showMessageDialog(null,"结果:"+df.format(result),"标题",JOptionPane.INFORMATION_MESSAGE);
	
		System.exit(0);
	}

}