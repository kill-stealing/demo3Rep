package com.ibm.demo.test.demo.col;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Person p1=new Person("您",100);
		Person p2=new Person("刘德华",1000);
		Person p3=new Person("梁朝伟",2900);
		Person p4=new Person("老裴",50);
		//依次存放到Treeset容器中
		TreeSet<Person> persons=new TreeSet<Person>(
		new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getHandsome()-o2.getHandsome();
			}
		});
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		for(Person p:persons){
			System.out.println(p.getName()+"-->"+p.getHandsome());
		}
		System.out.println("----------------------");
		for(Iterator<Person> it=persons.iterator();it.hasNext();){
			System.out.println(it.next().getName()+"-->"+it.next().getHandsome());
		}
		
		System.out.println(persons);
		
		/*TreeSet<Person> persons2=new TreeSet<Person>();
		//treeSet 在添加数据时排序
		persons2.add(p1);
		persons2.add(p2);
		persons2.add(p3);
		persons2.add(p4);
		System.out.println(persons2);*/
		Iterator<Person> it=persons.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName()+"-->"+it.next().getHandsome());
		}
		
		TreeSet<Integer> t=new TreeSet<Integer>();
		t.add(new Integer(1));
		t.add(2444);
		t.add(31);
		t.add(51);
		Iterator<Integer> it1=t.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
	}
}
