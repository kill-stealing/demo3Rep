package com.ibm.demo.test.demo.referenceTHree;

import java.util.IdentityHashMap;

/*
 * identityHashMap 键比较地址去重
 */
public class IdentityHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdentityHashMap<String,String> map=new IdentityHashMap<String, String>();
		map.put("a", "a1");
		map.put("a", "a2");
		System.out.println(map);
		map.put(new String("a"), "a3");
		map.put(new String("a"), "a4");
		System.out.println(map);
	}

}
