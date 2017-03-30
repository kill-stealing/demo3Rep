package com.ibm.demo.test.demo.designpattern.singleton;

public class Client {

	public static void main(String[] args) {
		SingletonDemo01 s1=SingletonDemo01.getInstance();
		SingletonDemo01 s2=SingletonDemo01.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(SingletonDemo04.INSTANCE==SingletonDemo04.INSTANCE);
	}

}
