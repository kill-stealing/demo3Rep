package com.ibm.demo.test;

public class TestSplit {
	public static void main(String[] args) {
		String aString="#112312#1#4#5#6";
		String[] aaStrings=aString.split("#");
		System.out.println(aaStrings);
	}
}
