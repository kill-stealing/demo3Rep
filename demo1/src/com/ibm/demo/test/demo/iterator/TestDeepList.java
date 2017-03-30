package com.ibm.demo.test.demo.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import sun.misc.JavaAWTAccess;


public class TestDeepList implements java.lang.Iterable{

	private String[] element = new String[5];;

	private int size = 0;

	public int size() {
		return this.size;
	}
	
	public void add(String str){
		if(this.size==element.length){
			element=Arrays.copyOf(element, element.length+5);
		}
		element[size]=str;
		size++;
	}
	
	private class MyIter implements Iterator{
		private int coursor=-1;
		
		public boolean hasNext(){
			return (coursor+1)<size;
		}
		
		public Object next(){
			coursor++;
			return element[coursor];
		}
		
		public void remove(){
			System.arraycopy(element, coursor+1, element, coursor, size-coursor-1);
			TestDeepList.this.size--;
			this.coursor--;
		}
	}
	
	public Iterator iterator1(){
		return new MyIter();
	}
	
	
	//匿名内部类
	public Iterator iterator2(){
		class MyIter implements Iterator{
			private int coursor=-1;
			
			public boolean hasNext(){
				return (coursor+1)<size;
			}
			
			public Object next(){
				coursor++;
				return element[coursor];
			}
			
			public void remove(){
				System.arraycopy(element, coursor+1, element, coursor, size-coursor-1);
				TestDeepList.this.size--;
				this.coursor--;
			}
		}
		return new MyIter();
	}
	
	public Iterator iterator(){
		return new Iterator(){
			private int coursor=-1;
			
			public boolean hasNext(){
				return (coursor+1)<size;
			}
			
			public Object next(){
				coursor++;
				return element[coursor];
			}
			
			public void remove(){
				System.arraycopy(element, coursor+1, element, coursor, size-coursor-1);
				TestDeepList.this.size--;
				this.coursor--;
			}
		};
	}

	public static void main(String[] args) {
		TestDeepList list =new TestDeepList();
		list.add("a");
		list.add("b");
		list.add("c1");
		list.add("c2");
		list.add("c3");
		list.add("c4");
		list.add("c5");
		Iterator it =list.iterator();
		while(it.hasNext()){ //���ж� ���ȡ
			System.out.println(it.next());
			//it.remove();
		}
		System.out.println(list.size());
		for(Object str:list){
			System.out.println(str);
		}
		
		
		ArrayList list2 =new ArrayList();
		list2.add("a");
		list2.add("a");
		list2.add("a");
		for(Object obj:list2){ //foreach
			System.out.println(obj);
		}
	
	}
}
