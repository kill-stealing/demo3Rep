package com.ibm.demo.test.demo.annotation.class1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ibm.demo.test.demo.annotation.javabean.User;

public class Demo04 {
	public static void test01(){
		User u=new User();
		
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			u.getuName();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("普通方法调用，执行10亿次，耗时："+(endTime-startTime)+" ms");
	}
	
	public static void test02() throws Exception{
		User u=new User();
		Class clz=u.getClass();
		Method m=clz.getDeclaredMethod("getuName", null);
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			m.invoke(u, null);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("反射方法调用，未禁用检查，执行10亿次，耗时："+(endTime-startTime)+" ms");
	}
	
	public static void test03() throws Exception{
		User u=new User();
		Class clz=u.getClass();
		Method m=clz.getDeclaredMethod("getuName", null);
		m.setAccessible(true);
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			m.invoke(u, null);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("反射方法调用，禁用检查，执行10亿次，耗时："+(endTime-startTime)+" ms");
	}
	
	public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
	}
}
