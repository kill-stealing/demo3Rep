package com.ibm.demo.test.exercise.sort;

import java.util.Arrays;

public class MaoPaoDemo {

	public static void main(String[] args) {
		int[] a1={5,4,3,2,1};
		int[] a3={5,1,2,3,4};
		sort1(a1);
		System.out.println("-----------a2-------");
		sort2(a3);
		System.out.println("-----------final-------");
		int[] a4={5,1,2,3,4};
		sort3(a4);
	}
	
	//简单版本
	public static void sort1(int[] a){
		for(int j=0;j<a.length;j++){
			System.out.println("第"+(j+1)+"趟");
			for(int i=0;i<a.length-1;i++){
				System.out.println("第"+(i+1)+"次");
				if(a[i]>a[i+1]){
					int temp=0;
					temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
				System.out.println(Arrays.toString(a));
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	//优化版本
	public static void sort2(int[] a){
		for(int j=0;j<a.length-1;j++){
			System.out.println("第"+(j+1)+"趟");
			for(int i=0;i<a.length-1-j;i++){
				System.out.println("第"+(i+1)+"次");
				if(a[i]>a[i+1]){
					int temp=0;
					temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
				System.out.println(Arrays.toString(a));
			}
		}
		System.out.println(Arrays.toString(a));
		
		
		
	}
	
	//最终版本
	public static void sort3(int[] a){
		boolean flag=true;
		for(int j=0;j<a.length-1;j++){
			flag=true;
			System.out.println("第"+(j+1)+"趟");
			for(int i=0;i<a.length-1-j;i++){
				System.out.println("第"+(i+1)+"次");
				if(a[i]>a[i+1]){
					int temp=0;
					temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					flag=false;
				}
				System.out.println(Arrays.toString(a));
			}
			if(flag){
				break;
			}
		}
	}

}
