package com.ibm.demo.test.demo;

import java.util.HashMap;

/*
 * 自定义自己的hashset
 */
public class SxtHashSet {
	
	HashMap map;
	private static final Object PRESENT = new Object();
	
	public int size(){
		return map.size();
	}
	
	public SxtHashSet() {
        map = new HashMap<>();
    }
	
	public void add(Object obj){
		map.put(obj, PRESENT);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SxtHashSet set2=new SxtHashSet();
		set2.add("aaa");
		set2.add("aaa");
		set2.add("a1231");
		System.out.println(set2.size());
	}

}
