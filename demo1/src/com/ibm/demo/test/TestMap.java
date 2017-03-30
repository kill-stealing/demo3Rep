package com.ibm.demo.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map map=new HashMap();
		map.put(1, "aaa");
		map.put(1, ":");
		System.out.println(map.containsKey(1));
		String aaa=(String)map.get(1);
	
		System.out.println(aaa);
	}
}
