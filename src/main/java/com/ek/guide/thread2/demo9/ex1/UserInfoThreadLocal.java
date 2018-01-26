package com.ek.guide.thread2.demo9.ex1;

public class UserInfoThreadLocal {
  
  
  public static void main(String[] args) {
    
    //线程一
    new Thread(new Runnable(){
      @Override
      public void run() {
        UserInfo userInfo = UserInfo.getThreadInstance();
        userInfo.setUserName("张三");
        userInfo.setAge(22);
        
        new A().aGet();
        new B().bGet();
        new C().cGet();
      }
    }).start();
    
    //线程二
    new Thread(new Runnable(){
      @Override
      public void run() {
        UserInfo userInfo = UserInfo.getThreadInstance();
        userInfo.setUserName("李四");
        userInfo.setAge(33);
        
        new A().aGet();
        new B().bGet();
        new C().cGet();
      }
    }).start();
    
  }
  
  
  
  static class A{
    public void aGet(){
      UserInfo userInfo = UserInfo.getThreadInstance();
      System.out.println(Thread.currentThread().getName()+"---"+userInfo.getUserName()+userInfo.getAge());
    }
  }
  
  static class B{
    public void bGet(){
      UserInfo userInfo = UserInfo.getThreadInstance();
      System.out.println(Thread.currentThread().getName()+"---"+userInfo.getUserName()+userInfo.getAge());
    }
  }
  
  static class C{
    public void cGet(){
      UserInfo userInfo = UserInfo.getThreadInstance();
      System.out.println(Thread.currentThread().getName()+"---"+userInfo.getUserName()+userInfo.getAge());
    }
  }

}
