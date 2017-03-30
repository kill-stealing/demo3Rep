package com.ibm.demo.test.demo.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExtendsTest {
	public static void main(String[] args) {
		List<? extends Fruit> list1=new ArrayList<Fruit>();
		test(list1);
	}
	
	public static void test(List<? extends Fruit> list){
		//不能这么加对象
	}
}
