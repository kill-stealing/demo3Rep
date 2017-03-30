package com.ibm.demo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReflect {
	public static void main(String[] args) {
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("aaa");
		try {
			Class c=new ArrayList<String>().getClass();
			Method m=c.getMethod("add",Object.class);
			m.invoke(list1, 11);
			System.out.println(Arrays.toString(list1.toArray()));
			
//			Class c=TestReflect.class;
//			Method m=c.getMethod("test1", String.class,Object.class);
//			TestReflect t=new TestReflect();
//			m.invoke(t, "aaa","bbb");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <E> void test1(String aaa,E e){
		System.out.println(aaa+e);
	}
}
