package com.ibm.demo.test;

import java.util.ArrayList;
import java.util.List;

public class TestRemoveSame {
	public static void main(String[] args){
		List<String> list1=new ArrayList<String>();
		list1.add("A1");
		list1.add("a1");
		list1.add("a1");
		list1.add("a2");
		list1.add("a3");
		List<String> list2=new ArrayList<String>();
		for(String a:list1){
			if(!list2.contains(a.toLowerCase())){
				list2.add(a.toLowerCase());
			}
		}
		for(String a1:list2){
			System.out.println(a1);
		}
	}

}
