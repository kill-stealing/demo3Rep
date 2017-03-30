package com.ibm.demo.test.demo.commons;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.bidimap.DualTreeBidiMap;

/*
 * 双向map 要求键和值不能重复
 * bidiMap 必须先反转 inverseBidiMap()
 * 1.DualTreeBidiMap:有序
 * 2.DualHashBidiMap:无序
 */
public class ShuangXiangMap {
	public static void main(String[] args) {
		hashMap();
		treeMap();
	}
	
	//有序的双向map
	public static void treeMap(){
		System.out.println("--------有序的双向map");
		BidiMap map=new DualTreeBidiMap();
		map.put("bj", "bj@test.com");
		map.put("sxt", "sxt@qq.com");
		//遍历查看
		MapIterator iterator=map.inverseBidiMap().mapIterator();
		while(iterator.hasNext()){
			iterator.next();
			String keyString=(String)iterator.getKey();
			String value=(String)iterator.getValue();
			System.out.println(keyString+"----"+value);
		}
		
	}
	
	//无序的双向map
	public static void hashMap(){
		System.out.println("--------无序的双向map");
		BidiMap map=new DualHashBidiMap();
		map.put("bj", "bj@test.com");
		map.put("sxt", "sxt@qq.com");
		//反转
		System.out.println(map.inverseBidiMap().get("sxt@qq.com"));
		//遍历查看
		MapIterator iterator=map.inverseBidiMap().mapIterator();
		while(iterator.hasNext()){
			iterator.next();
			String keyString=(String)iterator.getKey();
			String value=(String)iterator.getValue();
			System.out.println(keyString+"----"+value);
		}
		
	}
}
