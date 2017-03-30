package com.ibm.demo.test.demo.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.iterators.ArrayListIterator;
import org.apache.commons.collections.iterators.FilterIterator;
import org.apache.commons.collections.iterators.LoopingIterator;
import org.apache.commons.collections.iterators.UniqueFilterIterator;
import org.apache.commons.collections.map.HashedMap;

/*
 * 对迭代器的扩展
 * 1.MapIterator 以后不再使用 map,keySet,iterator访问
 * iterableMap hashedMap
 * 2.UniqueFilterIterator 去重迭代器
 * 3.FilterIterator 自定义过滤器+predicate
 * 4.LoopIterator 循环迭代器
 * 5.ArrayListIterator 数组迭代器
 */
public class IteratorDemo {
	public static void main(String[] args) {
//		mapIt();
//		uniqueIt();
//		filterIt();
//		loopIt();
		arrayIt();
	}
	
	//数组迭代器
	public static void arrayIt(){
		System.out.println("-----------数组迭代器");
		int[] ar={1,2,3,4,5};
//		Iterator<Integer> iterator=new ArrayListIterator(ar);
		//可以添加起始索引
		Iterator<Integer> iterator=new ArrayListIterator(ar,1,3);
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	//循环迭代器
	public static void loopIt(){
		System.out.println("----------循环迭代器------");
		List<String> list=new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("bjsxt");
		list.add("moom");
		
		Iterator<String> it=new LoopingIterator(list);
		for(int i=0;i<5;i++){
			System.out.println(it.next());
		}
	}
	
	//自定义过滤器
	public static void filterIt(){
		List<String> list=new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("bjsxt");
		list.add("moom");
		//自定义条件判断
		Predicate predicate=new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				String string=(String)obj;
				return new StringBuilder(string).reverse().toString().equals(string);
			}
		};
		
		
		Iterator<String> iterator=new FilterIterator(list.iterator(),predicate);
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	//去重迭代器
	public static void uniqueIt(){
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		Iterator<String> iterator=new UniqueFilterIterator(list.iterator());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	//map 迭代器
	public static void mapIt(){
		System.out.println(" -----------map 迭代器----");
		IterableMap map=new HashedMap();
		map.put("a", "bjsxt");
		map.put("b", "sxt");
		map.put("c", "good");
		
		//使用MapIterator
		MapIterator iterator=map.mapIterator();
		while(iterator.hasNext()){
			String keyString=(String)iterator.next();
			String value=(String)iterator.getValue();
			System.out.println(keyString+"---"+value);
		}
	}
}
