package com.ek.guide.callback;

/**
 * 在test中调用PojoDAO()的父类BaseDAO的deletePojo()方法
 * BaseDAO的deletePojo()方法又调用了getPojoClazz()在PojoDAO()中的具体实现
 * 子类调用父类方法的时候 父类又去调用了子类的方法
 * @author EK
 * @date 2017年7月30日
 */

public class Test1 {

	public static void main(String[] args) {
		PojoDAO dao = new PojoDAO();
		System.out.println("通过PojoDAO调用PojoDAO父类中的deletePojo()方法");
		dao.deletePojo();
	}
}