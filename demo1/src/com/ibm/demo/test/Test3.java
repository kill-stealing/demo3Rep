package com.ibm.demo.test;

import java.util.Collections;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5;
		int b=6;
		a=a^b;
		String abbb="fdsaf";
		String abbString="fdsafas";
		System.out.println(abbb.compareTo(abbString));;
		System.out.println(a);
		b=b^a;
		System.out.println(b);
		a=b^a;
		System.out.println(a);
		
		List<String> list=Collections.singletonList(new String());
//		list.add("test");
//		list.add("bjsxt");
		
		List<String> list1=Collections.emptyList();
		list1.add("aaa");
		System.out.println(list1.size());
		/*
		0101 a
		0110 b
		0011 a
		0101 b
		0110 a*/
	}

}
