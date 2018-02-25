package com.ek.guide.io.second.demo08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象流 序列化 反序列化
 */
public class ObjectStream {

  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    // serialize("F:/Downloads/io/emp.txt");
    deserialize("F:/Downloads/io/emp.txt");
  }

  /**---------<br>
   * @Title: deserialize
   * @Description: 反序列化
   * @param destPath
   * @throws FileNotFoundException
   * @throws IOException
   * @throws ClassNotFoundException
   * @return: void
   */
  public static void deserialize(String destPath) throws FileNotFoundException, IOException, ClassNotFoundException {
    File dest = new File(destPath);

    // 选择流
    ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dest)));
    // 操作 接收
    Object obj = input.readObject();
    if (obj instanceof Employee) { // 判断接收的是不是 Employee 类型
      Employee emp = (Employee) obj;
      System.out.println(emp.getName());
      System.out.println(emp.getSalary());
    }
    input.close();
  }

  /**---------<br>
   * @Title: serialize
   * @Description: 序列化
   * @param destPath
   * @throws FileNotFoundException
   * @throws IOException
   * @return: void
   */
  public static void serialize(String destPath) throws FileNotFoundException, IOException {
    Employee emp = new Employee("ek", 10000);
    File dest = new File(destPath);

    // 选择流
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
    // 操作 写出
    out.writeObject(emp);

    out.flush();
    out.close();
  }
}
