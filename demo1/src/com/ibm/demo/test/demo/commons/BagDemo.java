package com.ibm.demo.test.demo.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.collections.bag.TreeBag;

/*
 * bag 包 允许重复
 * 1.hashBag 无序
 * 2.treeBag 有序
 */
public class BagDemo {
	public static void main(String[] args) {
		hashBag();
		treeBag();
		
		String str="this is a cat and that is a mice where is the food";
		String[] strArray=str.split(" ");
		Bag bag=new TreeBag();
		for(String temp:strArray){
			bag.add(temp);
		}
		System.out.println("===========统计次数========");
		Set<String> keySet=bag.uniqueSet();
		for(String temp:keySet){
			System.out.println(temp+"-->"+bag.getCount(temp));
		}
	}
	
	//有序
	public static void treeBag(){
		System.out.println("-------有序的包");
		Bag bag=new TreeBag();
		bag.add("a");
		bag.add("a",5);
		bag.remove("a",2);
		bag.add("b");
		bag.add("c");
		Iterator<String> iterator=bag.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	//无序
	public static void hashBag(){
		System.out.println("-------无序的包");
		Bag bag=new HashBag();
		bag.add("a");
		bag.add("a",5);
		bag.remove("a",2);
		bag.add("b");
		bag.add("c");
		Iterator<String> iterator=bag.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
