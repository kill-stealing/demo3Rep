package com.ibm.demo.test;

public class TestExtend3 extends TestExtend2{ 
	public TestExtend3(){
		System.out.println(super.abc());
		System.out.println("TestExtend3");
	}
	public static void main(String[] args) {
		TestExtend3 testExtend3=new TestExtend3();
		System.out.println(testExtend3.getA());
		
		String aString="";
	}
}
