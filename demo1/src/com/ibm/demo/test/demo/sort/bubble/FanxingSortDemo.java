package com.ibm.demo.test.demo.sort.bubble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FanxingSortDemo {
	//容器排序
	public static <T extends Comparable> void sort(List<T> list){
		Object[] arr=list.toArray();
		sort(arr);
		for(int i=0;i<arr.length;i++){
			list.set(i, (T)arr[i]);
		}
		
	}
	
	//数组排序
	public static <T extends Comparable> void sort(T[] a){
		boolean sorted=true;
		for(int j=0;j<a.length-1;j++){
			sorted=true;
			for (int i = 0; i < a.length-j-1; i++) {
				if(((Comparable)a[i]).compareTo(a[i+1])>0){
					T temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					sorted=false;
				}
			}
			if(sorted){
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(Object[] a){
		boolean sorted=true;
		for(int j=0;j<a.length-1;j++){
			sorted=true;
			for (int i = 0; i < a.length-j-1; i++) {
				if(((Comparable)a[i]).compareTo(a[i+1])>0){
					Object temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					sorted=false;
				}
			}
			if(sorted){
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	
	}
	
	public static void main(String[] args) {
		String[] arrStrings={"abc","ab","a","def","dd"};
		FanxingSortDemo.sort(arrStrings);
		
		List<String> list=new ArrayList<String>();
		list.add("abc");
		list.add("ab");
		list.add("a");
		list.add("def");
		list.add("dd");
		FanxingSortDemo.sort(list);
	}
}
