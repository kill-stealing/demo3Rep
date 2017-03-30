package com.ibm.demo.test.demo.col;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo2 {
	public static void main(String[] args) {
		Worker w1=new Worker("垃圾回收员",12000);
		Worker w2=new Worker("农民工",8000);
		Worker w3=new Worker("程序员",5000);
		TreeMap<Worker,String> employees=new TreeMap<Worker,String>();
		employees.put(w1,"bjsxt");
		employees.put(w2,"bjsxt");
		employees.put(w3,"bjsxt");
		System.out.println(employees.keySet());
		
		Set<Worker> set=employees.keySet();
		Iterator<Worker> it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getType()+"-->"+it.next().getSalary());
		}
		
	}
}
