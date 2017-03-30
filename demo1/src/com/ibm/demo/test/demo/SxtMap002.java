package com.ibm.demo.test.demo;

import java.util.LinkedList;

/*
 * 自定义map的升级版
 * 1.提高查询的效率
 * 
 */
public class SxtMap002 {
	
	LinkedList[] arr=new LinkedList[999];//map的底层结构就是数组加链表
	int size;
	
	public void put(Object key,Object value){
		SxtEntry entry=new SxtEntry(key,value);
		int hash=key.hashCode();
		hash=hash<0?-hash:hash;
		int a=hash%999;
		if(arr[a]==null){
			LinkedList linkedList=new LinkedList();
			linkedList.add(entry);
			arr[a]=linkedList;
		}else{
			LinkedList list=arr[a];
			for(int i=0;i<list.size();i++){
				SxtEntry e2=(SxtEntry)list.get(i);
				if(e2.key.equals(key)){
					e2.value=value;
					return;
				}else{
					
				}
			}
			arr[a].add(entry);
		}
	}
	
	public Object get(Object key){
		int a=key.hashCode()%999;
		if(arr[a]!=null){
			LinkedList list=arr[a];
			for(int i=0;i<list.size();i++){
				SxtEntry entry=(SxtEntry)list.get(i);
				if(entry.key.equals(key)){
					return entry.value;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		SxtMap002 map=new SxtMap002();
		map.put(1, "aaa");
		map.put(1, ":");
		String aaa=(String)map.get(1);
		System.out.println(aaa);
	}
}
