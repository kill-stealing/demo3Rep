package com.ibm.demo.test.demo;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/*
 * 自己实现一个arrayList
 */
public class SxtArrayList {
	
	private Object[] elementData;
	private int size;
	
	public SxtArrayList(){
		
	}
	
	public SxtArrayList(int initialCapacity){
		if(initialCapacity<0){
			try {
				throw new Exception("ddddddd");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		elementData=new Object[initialCapacity];
	}
	
	public void add(Object a){
		if(size>=elementData.length){
			elementData[size]=a;
			Object[] newArray=new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData=newArray;
		}
	}
	
	public Object remove(int index){
		//删除指定位置的对象
		//a b d e
		try {
			if(index>=size){
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		int numMoved=size-index-1;
		if(numMoved>0){
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		elementData[--size]=null;
		return elementData[index];
	}
	
	private void rangeCheck(int index){
		if(index<0||index>=size){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public boolean remove(Object obj){
		if(obj==null){
			for (int i = 0; i < elementData.length; i++) {
				if(elementData[i]==null){
					remove(i);
					return true;
				}
			}
		}else{
			for (int i = 0; i < elementData.length; i++) {
				if(obj.equals(elementData[i])){
					remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public Object get(int index){
		return elementData[index];
	}
	
	public Object set(int index,Object obj){
		rangeCheck(index);
		Object object=elementData[index];
		elementData[index]=obj;
		return object;
	}
	
	public void add(int index,Object obj){
		rangeCheck(index);
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index]=obj;
		size++;
	}
	
	public void ensureCapacity(){
		if(size==elementData.length){
			Object[] newArray=new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, size);
			elementData=newArray;
		}
	}
	
	
	public static void main(String[] args) {
		List list=new ArrayList(2);
		list.add("a");
		list.add(1);
		list.add(3);
		list.add(2, "4");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
