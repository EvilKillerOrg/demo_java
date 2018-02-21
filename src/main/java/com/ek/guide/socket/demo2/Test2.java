package com.ek.guide.socket.demo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 获取资源(URL): 源 代码
 */
public class Test2 {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://www.163.com"); // 主页-默认资源

    // 获取资源(网络流)
    /*
    InputStream in = url.openStream();
    byte[] flush = new byte[1024];
    int len =0;
    len=in.read(flush);
    while(-1!=len){
      System.out.println(new String(flush,0,len));
    }
    in.close();
    */

    // 用转换流获取资源
    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));// 解码字符集
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"), "utf-8"));
    String msg = null;
    msg = br.readLine();
    while (msg != null) {
      System.out.println(msg);
      //bw.append(msg);
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
