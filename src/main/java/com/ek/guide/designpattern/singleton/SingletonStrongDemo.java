package com.ek.guide.designpattern.singleton;

import java.io.Serializable;

/**
 * 懒汉单例
 * 
 * 
 * @author EK
 * @date 2017年7月26日
 */
public class SingletonStrongDemo implements Serializable {

	private static SingletonStrongDemo instance;

	// 要防止 反射破解: 修改构造器,多次调用构造器的时候直接抛出一个异常(释放构造器中的if代码块生效)
	private SingletonStrongDemo() {
		// if(s!=null){
		// throw new RuntimeException();
		// }
	}

	public static synchronized SingletonStrongDemo getInstance() {
		if (instance == null) {
			instance = new SingletonStrongDemo();
		}
		return instance;
	}
	
	
	// 要防止 反串行化破解: 加这个方法就可以了,表示在反序列化时直接把已有实例instance返回而不需要把反序列化创建的新对象返回(释放readResolve()生效)
	// private Object readResolve(){
	// return instance;
	// }

}