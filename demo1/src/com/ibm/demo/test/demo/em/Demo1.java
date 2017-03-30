package com.ibm.demo.test.demo.em;

import java.util.Enumeration;
import java.util.Vector;

/*
 * Enumeration的使用
 * 判断hasMoreElements
 * 获取nextElement
 */
public class Demo1 {
	public static void main(String[] args) {
		Vector<String> vector=new Vector<String>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		//遍历该容器
		Enumeration<String> emEnumeration=vector.elements();
		while (emEnumeration.hasMoreElements()) {
			System.out.println(emEnumeration.nextElement());
			
		}
	}
}
