package com.ek.guide.log4j;

 

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FirstLog4jHello {
	static Logger logger = Logger.getLogger(FirstLog4jHello.class);
	public static void main(String[] args) {	
		int i,j;
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("target/classes/hellolog4j.properties");
		//logger.setLevel(Level.DEBUG);
		logger.info("Entering application."); //加载完自定义log4j资源文件 打印一下
		
		for(i=1;i<100;i++){
			logger.debug(""+i);
			for (j=1;j<=i;j++){
				logger.warn(">>>>"+j);
				System.out.print(i*j);
				System.out.print("\t");
				}
			System.out.println("");
				}
		logger.info("Exiting application.");
		
	}
}