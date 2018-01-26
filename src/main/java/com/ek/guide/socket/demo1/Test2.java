package com.ek.guide.socket.demo1;

import java.net.InetSocketAddress;

/**
 * InetSocketAddress 封装端口
 * @author EK
 * @date 2017年8月6日
 */
public class Test2 {
	public static void main(String[] args) {
		//InetSocketAddress addr1 = new InetSocketAddress(InetAddress.getLocalHost(),9999);
		InetSocketAddress addr1 = new InetSocketAddress("127.0.0.1",9999);
		System.out.println(addr1.getHostName());
		System.out.println(addr1.getPort()); //端口
	}

}