package com.ek.guide.io.second.demo08;

import java.io.Serializable;

/**
 * 用于测试序列化 反序列化的类
 */
public class Employee implements Serializable { // Serializable标识这个对象可以序列化
  private transient String name; // transient 代表这个属性不参与序列化
  private double salary;

  public Employee() {
  }

  public Employee(String name, double salary) {
    super();
    this.name = name;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
}
