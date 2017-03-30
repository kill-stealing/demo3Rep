package com.ibm.demo.test.exercise.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class StringDemo {
	public static void main(String[] args) {
		String[] arr={"a","ab","abc","dafsd"};
		Utils.sort(arr, new ComparatorDemo());
		System.out.println(Arrays.toString(arr));
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("ab");
		list.add("abc");
		list.add("dafsd");
		
		Utils.sort(list, new ComparatorDemo());
		System.out.println(Arrays.toString(list.toArray()));
		
		Collections.sort(list,new ComparatorDemo());
		System.out.println("ddddddddddddddddddddddd");
		System.out.println(Arrays.toString(list.toArray()));
		Collections.sort(list);
		System.out.println("ddddddddddddddddddddddd");
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println("ddddddddddddddddddddddd");
		System.out.println(Arrays.toString(list.toArray()));
	}
}
