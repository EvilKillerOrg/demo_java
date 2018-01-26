package com.ek.guide.log4j;

import org.apache.log4j.Logger;

public class MyApp {
//	 Define a static logger variable so that it references the
	   // Logger instance named "MyApp".
	   static Logger logger = Logger.getLogger(MyApp.class);
	   public static void main(String[] args) {
	     // Set up a simple configuration that logs on the console.

	     logger.info("Entering application.");
	     MyAppBar bar = new MyAppBar();
	     bar.doIt();
	     logger.info("Exiting application.");

        }
}