package com.ibm.demo.test.demo.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sun.tools.jar.resources.jar;

/*
 * binarySearch 容器有序
 * 
 */
public class CollectionDemo01 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<54;i++){
			list.add(i);
		}
		Collections.shuffle(list);
		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		List<Integer> list3=new ArrayList<Integer>();
		for(int i=0;i<51;i=i+3){
			list1.add(i);
			list2.add(i+1);
			list3.add(i+2);
		}
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}
	
	public static void rever1(List<Integer> list){
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("反转"+list);
	}
}
