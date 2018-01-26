package com.ek.guide.zqiming.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// 利用反射的抽象DAO
public class BaseDAO {
	/**
	 *   网上看到的:
	 *   java.lang.Object中getClass()方法的用途：
	 *  可以获取一个类的定义信息，然后使用反射去访问其全部信息(包括函数和字段)。
	 *  还可以查找该类的ClassLoader，以便检查类文件所在位置等。 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addVO(Object obj){ //传VO变成传Object
		
		try {
			
			
			if(obj==null){
				return;
			}
			 
			Class objClass = obj.getClass(); //获得反射对象 
			
			//拼接sql
			StringBuffer insert = new StringBuffer("insert into ");
			StringBuffer valueField = new StringBuffer(" ) value ( ");
			List<Object> valuesList = new ArrayList<Object>(); // ? 代表的值
			
			insert.append(objClass.getSimpleName()).append(" ( "); //获得类名作为表名( getName(..) 返回的是包名)
			
			Field[] fields = objClass.getDeclaredFields(); //获得所有属性名
			for (Field field : fields) {
				insert.append(field.getName()).append(","); //拼接域名
				valueField.append("?,"); //拼接预处理' , '
				
				String methodName = "get"+field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1);//拼接get方法名
				Method getMethod = objClass.getMethod(methodName); //获得get方法
				Object returnValue = getMethod.invoke(obj); //获得get方法的返回值

				valuesList.add(returnValue);
			}
			
			String insertSQL = insert.substring(0, insert.length()-1)+valueField.substring(0, valueField.length()-1)+" )"; //去掉最后一个" , "
			
			System.out.println(insertSQL);
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}