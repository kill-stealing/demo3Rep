package com.ibm.demo.test.demo.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.collections.functors.UniquePredicate;
import org.apache.commons.collections.list.PredicatedList;

import sun.launcher.resources.launcher;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println("-========非空判断========");
		Predicate notNullPredicate=NotNullPredicate.getInstance();
		String str=null;
		System.out.println(notNullPredicate.evaluate(str));
		
		//添加容器值的判断
		List<Long> list=PredicatedList.decorate(new ArrayList<Long>(), notNullPredicate);
		list.add(1000L);
//		list.add(null);
		System.out.println(notNullPredicate.evaluate(list));
		
		Predicate predicate=UniquePredicate.getInstance();
		List<Long> list2=PredicatedList.decorate(new ArrayList<Long>(), predicate);
		list2.add(100L);
		list2.add(300l);
		list2.add(300l);
		System.out.println(predicate.evaluate(list2));
		
		//自定义判别式
		Predicate predicate2=new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				
				return false;
			}
		};
		
	}
}
