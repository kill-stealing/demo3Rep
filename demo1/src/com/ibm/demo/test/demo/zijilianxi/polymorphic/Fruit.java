package com.ibm.demo.test.demo.zijilianxi.polymorphic;

import java.util.ArrayList;
import java.util.List;

public class Fruit {
	public static void main(String[] args) {
		List<Fruit> list=new ArrayList<Fruit>();
		
		List<Apple> list1=new ArrayList<Apple>();
		
		List<Object> list2=new ArrayList<Object>();
		
		test(list);
		
		test1(list1);
		
		test1(list2);
		
		Fruit[] f=new Fruit[12];
		f[0]=(Fruit) new Object();
		
		Object[] o=new Object[123];
		o[0]=new Fruit();
		
		Fruit a=(Fruit)o[0];
	}
	
	public static void test(List<? extends Fruit> list){
		List<Fruit> list1=new ArrayList<Fruit>();
		list.add(null);
	}
	
	public static void test1(List<? super Apple> list){
		list.add(new Apple());
		list.add(new FujiApple());
	}
}

class Apple extends Fruit{
	
}
class Pear extends Fruit{
	
}

class FujiApple extends Apple{
	
}

