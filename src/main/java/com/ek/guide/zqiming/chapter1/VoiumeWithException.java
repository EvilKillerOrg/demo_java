package com.ek.guide.zqiming.chapter1;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class VoiumeWithException {
	
	public static void main(String[] args) {
	
		try{
		String inputValue = JOptionPane.showInputDialog("输入半径:");
		double radius = Double.parseDouble(inputValue);
		double result = 0;
		result = 4.0/3*Math.PI*Math.pow(radius, 3);//pow的参数是 半径 和 3次方
		//4除以3的话 结果是 int型 , 4是常量也没有必要强制类型转换,直接写成4.0就好了(自动转换也叫隐式转换)
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		JOptionPane.showMessageDialog(null,"半径是:"+radius+"\n体积是:"+df.format(result),"标题",JOptionPane.INFORMATION_MESSAGE);
		
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"没有输入正确信息","标题",JOptionPane.ERROR_MESSAGE);
		}
		
		System.exit(0);
	}

}