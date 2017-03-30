package com.ibm.demo.test.demo.zijilianxi.reflect;

public class Demo01 {

	public static void main(String[] args) throws ClassNotFoundException {
		String str="abc";
		
		Class<?> cla=str.getClass();
		cla=String.class;
		cla=Class.forName("java.lang.String");
	}

}
