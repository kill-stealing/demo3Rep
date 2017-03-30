package com.ibm.demo.test.demo;

import java.util.HashMap;
import java.util.Map;

/*
 * 自定义实现map的功能
 * map 存放键值对，根据键对象找到值对象
 */
public class SxtMap001 {
	
	SxtEntry[] arr=new SxtEntry[990];
	int size;
	
	public void put(Object key,Object value){
		SxtEntry entry=new SxtEntry(key, value);
		//解决键值重复的问题
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				arr[i].value=value;
				return;
			}
		}
		arr[size++]=entry;
	}
	
	public Object get(Object key){
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				return arr[i].value;
			}
		}
		return null;
	}
	
	public boolean containsKey(Object key){
		for (int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SxtMap001 map=new SxtMap001();
		map.put(1, "aaa");
		map.put(1, ":");
		String aaa=(String)map.get(1);
	
		System.out.println(aaa);
	}
}
