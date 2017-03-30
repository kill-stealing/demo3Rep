package com.ibm.demo.test.demo.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

public class Demo04 {
	public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		Set<Integer> set2=new HashSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		//并集
		Collection<Integer> collections=CollectionUtils.union(set,set2);
		for(Integer temp:collections){
			System.out.println(temp);
		}
		//交集
		collections=CollectionUtils.intersection(set, set2);
		for(Integer temp:collections){
			System.out.println(temp);
		}
		//差集
		collections=CollectionUtils.subtract(set, set2);
		for(Integer temp:collections){
			System.out.println(temp);
		}
		
	}
}
