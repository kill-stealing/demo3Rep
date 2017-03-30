package com.ibm.demo.test.demo.referenceTHree;

import java.util.WeakHashMap;

/*
 * WeakHashMap 键为弱引用 gc运行立即回收
 */
public class WeakHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeakHashMap<String, String> map=new WeakHashMap<String, String>();
		//测试数据
		//常量池对象 不回收
		map.put("abc", "a");
		map.put("d", "test");
		//gc运行已被回收
		map.put(new String("bjsxt"), "c");
		map.put(new String("dsf"), "d");
		System.gc();
		System.runFinalization();
		System.out.println(map);
		
		
	}

}
