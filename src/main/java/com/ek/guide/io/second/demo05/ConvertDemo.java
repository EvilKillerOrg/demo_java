package com.ek.guide.io.second.demo05;

import java.io.UnsupportedEncodingException;

/**
 * 编码与解码
 */
public class ConvertDemo {

  public static void main(String[] args) throws UnsupportedEncodingException {

    // 解码 byte ---> char
    String str = "中国"; // 默认的UTF-8

    /*----------------------------------------------------*/

    // 编码 char ---> byte
    byte[] data1 = str.getBytes(); // 默认的UTF-8
    // 解码 byte ---> char
    String s1 = new String(data1); // 默认的UTF-8

    System.out.println(s1); // 编码和解码字符集统一

    /*----------------------------------------------------*/

    // 编码 设定编码字符集
    byte[] data2 = str.getBytes("GBK"); // 设定的GBK
    // 解码
    String s2 = new String(data2); // 默认的UTF-8

    System.out.println(s2); // 编码和解码字符集不统一,出现乱码

    /*----------------------------------------------------*/

    // 编码 设定编码字符集
    byte[] data3 = "中国".getBytes("GBK"); // 设定的GBK
    // 解码 设定解码字符集
    String s3 = new String(data3, "GBK"); // 设定的GBK

    System.out.println(s3); // 编码和解码字符集统一

  }
}
