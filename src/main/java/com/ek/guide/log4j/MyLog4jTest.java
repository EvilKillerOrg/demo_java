package com.ek.guide.log4j;

import org.apache.log4j.Logger;

public class MyLog4jTest {
	private static Logger logger = Logger.getLogger(MyLog4jTest.class); //设为static 只实例化一次 , 参数传类.class
	
	
	public static void main(String[] args){
		if(logger.isDebugEnabled()){ //1.加个判断是否是debug等级(为了提高效率)
			logger.debug("Entry xxXXX method!>>>");
		} 
		
		//...
		
		if(logger.isDebugEnabled()){
			logger.debug("Finish xxXXX method!>>>");
		} 
	}
}