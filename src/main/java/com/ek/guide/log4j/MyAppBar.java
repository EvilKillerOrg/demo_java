package com.ek.guide.log4j;

import org.apache.log4j.Logger;


public class MyAppBar {

	private static Logger logger = Logger.getLogger(MyAppBar.class);
	   public void doIt() {
	     logger.info("Did it again!");
	   }
}
