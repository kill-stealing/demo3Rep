package com.ibm.demo.test.demo.iterator;

import java.util.Arrays;
import java.util.Iterator;

/*
 * 使用泛型，操作多个类型
 */
public class TestArrayList<E> implements java.lang.Iterable<E> {
	
	private Object[] element = new Object[5];;

	private int size = 0;

	public int size() {
		return this.size;
	}
	
	public void add(E e){
		if(this.size==element.length){
			element=Arrays.copyOf(element, element.length+5);
		}
		element[size]=e;
		size++;
	}
	
	public Iterator<E> iterator(){
		return new Iterator<E>(){
			private int coursor=-1;
			
			public boolean hasNext(){
				return (coursor+1)<size;
			}
			
			public E next(){
				coursor++;
				return (E)element[coursor];
			}
			
			public void remove(){
				System.arraycopy(element, coursor+1, element, coursor, size-coursor-1);
				size--;
				this.coursor--;
			}
		};
	}
	
	public static void main(String[] args) {
		TestArrayList<Integer> list =new TestArrayList<Integer>();
		list.add(1);//int -->Integer
		list.add(2);
		for(Integer e:list){
			System.out.println(e);
		}
		System.out.println("----------------");
		SxtArrayList<String> list2 =new SxtArrayList<String>();
		list2.add("aaa");
		list2.add("b");
		list2.add("cccc");
		list2.add("dddd");
		
		Iterator<String> it =list2.iterator();
		while(it.hasNext()){
			String e =it.next();
			System.out.println(e);
		}
	}
}
