package com.ibm.demo.test.demo.iterator;

import java.awt.geom.CubicCurve2D;

import org.apache.jasper.tagplugins.jstl.core.Remove;

public class TestSimpleList {
	private String[] element={"a","b","c"};
	
	private int size=element.length;
	
	public int size(){
		return this.size;
	}
	
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
		this.size--;
		this.coursor--;
	}
	
	public static void main(String[] args) {
		TestSimpleList list=new TestSimpleList();
		if(list.hasNext()){
			System.out.println(list.next());
			list.remove();
		}
		if(list.hasNext()){
			System.out.println(list.next());
			list.remove();
		}
		if(list.hasNext()){
			System.out.println(list.next());
			list.remove();
		}
		System.out.println(list.size());
	}
}
