package com.ek.guide.zqiming.chapter1;

import javax.swing.JOptionPane;

public class HelloWorld {

	public static void main(String args[]){
		String input = JOptionPane.showInputDialog("请输入你的名字");
		
		JOptionPane.showMessageDialog(null,"HELLO!"+input,"标题",JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
	}
}