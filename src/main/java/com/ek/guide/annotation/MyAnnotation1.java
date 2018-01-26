package com.ek.guide.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 源注解 用来给注解做注解:
 * 1. @Retention (注解保留的范围)
 * 2. @Target (注解存在的位置)
 * 
 * 
 * 值:
 * ElementType.TYPE 指用于修饰类
 * ElementType.METHOD 指用于修饰方法
 * 
 * RetentionPolicy.SOURCE
 * RetentionPolicy.CLASS
 * RetentionPolicy.RUNTIME
 * 自定义注解一般就用RetentionPolicy.RUNTIME 用这个代表 SOURCE CLASS 都有效
 * RUNTIME级别可以用反射读取到
 * 
 * @author EK
 * @date 2017年7月30日
 */

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD , ElementType.TYPE})  
public @interface MyAnnotation1 {
	
	String  userName() default ""; //这里表示的不是方法 而是一个参数 类型+参数名  default后面是默认值
	int age() default -1; 
	int id() default -1;
}