package com.ibm.demo.test.demo.classloadprocess1;

public class Demo02 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		
		System.out.println("-=======================");
		String a="gaoqi";
		System.out.println(a.getClass().getClassLoader());
		System.out.println(a);
	}
}
