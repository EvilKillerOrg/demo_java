package com.ek.guide.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则
 * 主要的就是两个包
 * java.util.regex.Pattern //表达式对象
 * java.util.regex.Matcher //匹配对象
 */
public class Demo01 {

  public static void main(String[] args) {
    // matches();
    // find();
    // group();
    // replace();
    split();
  }

  /**---------<br>
   * @Title: matches
   * @Description: matches()方法尝试将整个字符序列与该模式匹配
   * @return: void
   */
  public static void matches() {
    String str = "fghjk45678";

    // 表达式对象
    Pattern p = Pattern.compile("\\w+");

    // 匹配对象
    Matcher m = p.matcher(str);

    // 获取匹配结果
    boolean result = m.matches(); // 尝试将整个字符序列与该模式匹配
    System.out.println(result);
  }

  /**---------<br> 
   * @Title: find
   * @Description: find()方法扫描输入的序列,查找与该模式匹配的下一个子序列
   * @return: void
   */
  public static void find() {
    String str = "fghjk&45678"; // 注意哈!中间的& 是不符合\w的哦.

    // 表达式对象
    Pattern p = Pattern.compile("\\w+");

    // 匹配对象
    Matcher m = p.matcher(str);

    // 获取匹配结果
    boolean result = m.find(); // 该方法扫描输入的序列,查找与该模式匹配的下一个子序列
    String regexStr = m.group(); // 获得匹配到的字符串
    System.out.println(result); // 输出的是第一次匹配到的,输出true
    System.out.println(regexStr); // 返回第一次匹配到的字符串

    System.out.println(m.find()); // 输出的是第二次匹配到的, 是45678, 输出true
    System.out.println(m.group()); // 返回第二次匹配到的字符串

    System.out.println(m.find()); // 第三次没有匹配到 输出false
    System.out.println(m.group()); // 返回第三次匹配到的 第三次没有了 返回一个异常

    // 写个循环把匹配的 子序列都打印出来
    /*
    while(m.find()){
      System.out.println(m.group());
    }
    */
  }

  /**---------<br>
   * @Title: group
   * @Description: 测试一下分组的处理(捕获组)
   * @return: void
   */
  public static void group() {
    String str = "wad233*fddfd4368**fdfds545";

    // 表达式对象
    Pattern p = Pattern.compile("([a-z]+)([0-9]+)");

    // 匹配对象
    Matcher m = p.matcher(str);

    // 输出捕获组
    while (m.find()) {
      System.out.println(m.group(1));
      System.out.println(m.group(2));
    }
  }

  /**---------<br>
   * @Title: replace
   * @Description: 使用正则做替换
   * @return: void
   */
  public static void replace() {
    String str = "wad233*fddfd4368**fdfds545";

    // 表达式对象
    Pattern p = Pattern.compile("[0-9]");

    // 匹配对象
    Matcher m = p.matcher(str);

    // 替换 (数字替换成#)
    String newStr = m.replaceAll("#");
    System.out.println(newStr);
  }

  /**---------<br>
   * @Title: split
   * @Description: 字符串分割
   * @return: void
   */
  public static void split() {
    // 以逗号作为边界分割
    String str1 = "a,b,c,d,e,f,g";
    String[] arrs1 = str1.split(",");
    System.out.println(Arrays.toString(arrs1));
    
    //以数字作为边界分割
    String str2 = "a1b2c3d4e5f6g";
    String[] arrs2 = str2.split("\\d+");
    System.out.println(Arrays.toString(arrs2));
    
  }
}
