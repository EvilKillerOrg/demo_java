package com.ek.guide.zqiming.chapter2;

import javax.swing.JOptionPane;

public class SwitchCaseDemo1 {
 
	public static void main(String[] args) {
		/*		
		表达式可以是: byte short long char 变量 表达式
		switch(表达式){
		case 选择一:
			statements;
			break;
		case 选择二:
			statements;
			break;
			
		....
		default
		statements;
		break;
		}
		*/
		
		double firstValue=100;
		double secondValue=50;
		double result = 0;
		String resultExpression = null;
		
		String input = JOptionPane.showInputDialog("请输入运算符号:(+ , - , * , / , %):");
		char ch = input.charAt(0);//取String中的第一个字符
		switch(ch){
		case'+':
			result=firstValue+secondValue;
			resultExpression=firstValue+" "+ch+" "+secondValue+"="+result;
			JOptionPane.showMessageDialog(null,resultExpression,"标题",JOptionPane.INFORMATION_MESSAGE);
			break;
		case'-':
			result=firstValue-secondValue;
			resultExpression=firstValue+" "+ch+" "+secondValue+"="+result;
			JOptionPane.showMessageDialog(null,resultExpression,"标题",JOptionPane.INFORMATION_MESSAGE);
			break;
		case'*':
			result=firstValue*secondValue;
			resultExpression=firstValue+" "+ch+" "+secondValue+"="+result;
			JOptionPane.showMessageDialog(null,resultExpression,"标题",JOptionPane.INFORMATION_MESSAGE);
			break;
		case'/':
			result=firstValue/secondValue;
			resultExpression=firstValue+" "+ch+" "+secondValue+"="+result;
			JOptionPane.showMessageDialog(null,resultExpression,"标题",JOptionPane.INFORMATION_MESSAGE);
			break;
		case'%':
			result=firstValue%secondValue;
			resultExpression=firstValue+" "+ch+" "+secondValue+"="+result;
			JOptionPane.showMessageDialog(null,resultExpression,"标题",JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null,"输入的不对!","标题",JOptionPane.ERROR_MESSAGE);
			break;
		}
		System.exit(0);
	}

}