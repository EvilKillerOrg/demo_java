package com.ek.guide.socket.demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * IP
 * InetAddress 封装IP地址和DNS(域名解析), 没有封装端口 
 */
public class Test1 {
	public static void main(String[] args) throws UnknownHostException {
		
		//试用getLocalHost() 创建InetAddress对象(本机)
		InetAddress addr1 = InetAddress.getLocalHost();
		System.out.println("本机Address: "+addr1.getHostAddress());//获得本机IP
		System.out.println("本机Name: "+addr1.getHostName());//获得计算机名
		
		//根据域名获得InetAddress对象
		InetAddress addr2 = InetAddress.getByName("www.163.com");
		System.out.println("根据域名Address: "+addr2.getHostAddress());//获得163的IP
		System.out.println("根据域名Name: "+addr2.getHostName());//获得163名
		
		//根据IP获得InetAddress对象
		InetAddress addr3 = InetAddress.getByName("61.125.253.15");
		System.out.println("根据地址Address: "+addr3.getHostAddress()); 
		System.out.println("根据地址Name: "+addr3.getHostName());
	}
}