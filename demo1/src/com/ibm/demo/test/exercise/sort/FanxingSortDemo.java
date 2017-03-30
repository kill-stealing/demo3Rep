package com.ibm.demo.test.exercise.sort;

import java.util.Arrays;

public class FanxingSortDemo {
	
	public static void main(String[] args) {
		String[] a={"abc","ab","abd","dd","bb"};
		sortFanxing(a);
	}
	
	public static <T extends Comparable<T>> void sortFanxing1(T[] a){
		boolean sorted=true;
		for(int j=0;j<a.length-1;j++){
			sorted=true;
			System.out.println("第"+(j+1)+"趟");
			for (int i = 0; i < a.length-j-1; i++) {
				System.out.print("第"+(i+1)+"次");
				if(((Comparable)a[i]).compareTo((Comparable)a[i+1])>0){
					T temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					sorted=false;
				}
				System.out.println(Arrays.toString(a));
			}
			if(sorted==true){
				break;
			}
		}
	}
	
	public static void sortFirst(int[] a){
		boolean sorted=true;
		for(int j=0;j<a.length-1;j++){
			sorted=true;
			System.out.println("第"+(j+1)+"趟");
			for (int i = 0; i < a.length-j-1; i++) {
				System.out.print("第"+(i+1)+"次");
				if(((Comparable)a[i]).compareTo((Comparable)a[i+1])>0){
					/*a[i]=a[i]+a[i+1];
					a[i+1]=a[i]-a[i+1];
					a[i]=a[i]-a[i+1];*/
					
					/*a[i]=a[i]^a[i+1];
					a[i+1]=a[i+1]^a[i];
					a[i]=a[i]^a[i+1];*/
					
					a[i+1]=a[i]+0*(a[i]=a[i+1]);
					
					/*int temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;*/
					sorted=false;
				}
				System.out.println(Arrays.toString(a));
			}
			if(sorted==true){
				break;
			}
		}
	}
	
	//数组排序（使用泛型方法）
	public static <T extends Comparable<T>> void sortFanxing(T[] a){
		boolean sorted=true;
		for(int j=0;j<a.length-1;j++){
			sorted=true;
			System.out.println("第"+(j+1)+"趟");
			for (int i = 0; i < a.length-j-1; i++) {
				System.out.print("第"+(i+1)+"次");
				if(((Comparable)a[i]).compareTo((Comparable)a[i+1])>0){
					T temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					sorted=false;
				}
				System.out.println(Arrays.toString(a));
			}
			if(sorted==true){
				break;
			}
		}
	}
}
