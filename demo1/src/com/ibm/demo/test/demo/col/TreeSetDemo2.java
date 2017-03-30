package com.ibm.demo.test.demo.col;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo2 {
	public static void main(String[] args) {
			Worker w1=new Worker("垃圾回收员",12000);
			Worker w2=new Worker("农民工",8000);
			Worker w3=new Worker("程序员",5000);
			TreeSet<Worker> employees=new TreeSet<Worker>();
			employees.add(w1);
			employees.add(w2);
			employees.add(w3);
			System.out.println(employees);
			
			Iterator<Worker> it=employees.iterator();
			
			while(it.hasNext()){
				System.out.println(it.next());
			}
			
			Set<String> s=new HashSet<String>();
			s.add("a");
			s.add("a");
			Iterator<String> its=s.iterator();
			
			while(its.hasNext()){
				System.out.println(its.next());
			}
			
			Map<String, String> m=new HashMap<String, String>();
			m.put("a", "abc");
			m.put("b", "bbc");
			m.put("c", "cbc");
			m.put("d", "dbc");
			m.put("c", "cbcccccc");
			Iterator<String> itm=m.keySet().iterator();
			
			while(itm.hasNext()){
				System.out.println(m.get(itm.next()));
			}
	}
}
