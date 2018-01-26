package com.ek.guide.callback;

import java.io.Serializable;

public abstract class BaseDAO<T , PK extends Serializable  > {
	public abstract  Class<T> getPojoClazz();
	
	public void deletePojo(){
		System.out.println("BaseDAO的deletePojo()方法的被调用");
		System.out.println("同时去调用BaseDAO的getPojoClazz方法()的实现");
		this.getPojoClazz();
		
	}
}