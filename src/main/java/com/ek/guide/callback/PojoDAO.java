package com.ek.guide.callback;

public class PojoDAO extends BaseDAO<PojoVO , Integer>{

	@Override
	public Class<PojoVO> getPojoClazz() {
		System.out.println("PojoDAO的getPojoClazz()方法被调用");
		return PojoVO.class;
	}

}