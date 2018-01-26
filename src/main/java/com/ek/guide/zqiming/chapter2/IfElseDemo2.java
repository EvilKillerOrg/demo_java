package com.ek.guide.zqiming.chapter2;

import javax.swing.JOptionPane;

public class IfElseDemo2 {
	
	public static void main(String[] args) {
		
		String username = "admin";
		String password = "888";
		
		String usernameVal = JOptionPane.showInputDialog("用户名:");
		String passwordVal = JOptionPane.showInputDialog("密码:");
		
//		if(username==usernameVal&&password==passwordVal){
//			JOptionPane.showMessageDialog(null,"进入","标题",JOptionPane.INFORMATION_MESSAGE);
//		}else{
//			JOptionPane.showMessageDialog(null,"错误","标题",JOptionPane.ERROR_MESSAGE);
//		}
		
		if(username.equals(usernameVal)&&password.equals(passwordVal)){
			JOptionPane.showMessageDialog(null,"进入","标题",JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null,"错误","标题",JOptionPane.ERROR_MESSAGE);
		}
		
		System.exit(0);
	}

}