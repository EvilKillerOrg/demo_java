package com.ek.guide.thread2.demo9.ex1;
/**
 * 优雅的把ThreadLocal的封装写在了被调用者内部中了,调用者不用关心ThreadLocal是怎么封装在被调用者中的
 * @ClassName: UserInfo
 * @Description: TODO
 * @author: ek
 * @date: 2018年1月19日 上午3:43:24
 */
public class UserInfo {
  
  private UserInfo(){}
  
  private static ThreadLocal<UserInfo> threadLocalMap = new ThreadLocal<UserInfo>();
  
  public static UserInfo getThreadInstance(){
    UserInfo userInfo = threadLocalMap.get();
    if(userInfo==null){
      userInfo = new UserInfo();
      threadLocalMap.set(userInfo);
    }
    return userInfo;
  }
  

  private String userName;
  private Integer age;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
