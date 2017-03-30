package com.ibm.demo.test.demo.annotation.class1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息(类的名字，属性，方法，构造器等)
 * 
 * @author liumy
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "com.ibm.demo.test.demo.annotation.javabean.User";

		try {
			Class<?> claz = Class.forName(path);
			System.out.println(claz.getName());//获得包名+类名
			System.out.println(claz.getSimpleName());
			
			//获取属性信息
//			Field[] fields=claz.getFields();//只能获得public的field
			Field[] fields=claz.getDeclaredFields();//获得所有的field
			Field f=claz.getDeclaredField("uName");
			System.out.println(fields.length);
			//获取方法信息
			Method[] methods=claz.getMethods();
			Method m=claz.getMethod("getuName", null);
			//如果方法有参数，则必须传递参数类型对应的class对象
			Method m1=claz.getMethod("setuName", String.class);
			//获取构造器信息
			Constructor[] cs=claz.getDeclaredConstructors();
			Constructor constructor=claz.getDeclaredConstructor(null);
			Constructor c1=claz.getDeclaredConstructor(int.class,int.class,String.class);
		} catch (Exception e) {

		}
	}
}
