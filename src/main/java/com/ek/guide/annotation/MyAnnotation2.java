package com.ek.guide.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author EK
 * @date 2017年7月30日
 */

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD , ElementType.TYPE})  
public @interface MyAnnotation2 {
	
	 String value(); //只有一个参数 一般参数名定义为value(给值的时候就不用写参数名了)
	
}
