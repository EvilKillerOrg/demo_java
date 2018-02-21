package com.ek.guide.socket.demo2;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 构建URL 
 */
public class Test1 {

  public static void main(String[] args) throws MalformedURLException {

    // 绝对路径构建
    // #aa 是锚点(锚点是写死的) ?uname=ek是参数(参数是用户输入的)
    URL url1 = new URL("http://www.baidu.com:80/index.html#aa?uname=ek");

    // 相对路径构建
    URL url2 = new URL("http://www.baidu.com:80/a/");
    url2 = new URL(url2, "b.txt");

    System.out.println(url1);
    System.out.println(url2);

    System.out.println("查看协议: " + url1.getProtocol());
    System.out.println("查看域名: " + url1.getHost());
    System.out.println("查看端口: " + url1.getPort());
    System.out.println("查看资源名: " + url1.getFile());
    System.out.println("查看相对路径资源: " + url1.getPath());
    System.out.println("查看锚点: " + url1.getRef());
    System.out.println("查看参数: " + url1.getQuery()); // ?后的参数:
                                                    // 当存在锚点参数就被当成是锚点的一部分,这里就成了null
  }
}
