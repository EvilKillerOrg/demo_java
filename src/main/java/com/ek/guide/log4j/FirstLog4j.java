package com.ek.guide.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class FirstLog4j {
//记录器
	public static  void main(String[] args)
	{
//		 get a logger instance named "com.foo"
		   Logger  logger = Logger.getLogger("firstlog");
		   //Logger  logger1 = Logger.getLogger("abc");
		   // Now set its level. Normally you do not need to set the
		   // level of a logger programmatically. This is usually done
		   // in configuration files.
		   // DEBUG < INFO < WARN < ERROR < FATAL. 
		   logger.setLevel(Level.DEBUG); //不设置这个的话 执行log4j.properties中的缺省设置
		 
		   
		   Logger barlogger = Logger.getLogger("firstlog.Bar"); //firstlog.Bar 和 firstlog 是继承关系 以firstlog前缀的都会执行 firstlog(根记录器)的 level

		   // This request is enabled, because WARN >= INFO.
		   logger.warn("Low fuel level.");

		   // This request is disabled, because DEBUG < INFO.
		   logger.debug("Starting search for nearest gas station.");

		   // The logger instance barlogger, named "com.foo.Bar",
		   // will inherit its level from the logger named
		   // "com.foo" Thus, the following request is enabled
		   // because INFO >= INFO.
		   barlogger.info("Located nearest gas station.");

		   // This request is disabled, because DEBUG < INFO.
		   barlogger.debug("Exiting gas station search");

	}
}