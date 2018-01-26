package com.ek.guide.zqiming.reflect;

import java.util.Date;

public class TestBaseDAO {

	 //testAddVO
	public static void main(String[] args) {
		BaseDAO dao = new BaseDAO();
		dao.addVO(new TestReflectVO("dd", new Date()));
	}

}
