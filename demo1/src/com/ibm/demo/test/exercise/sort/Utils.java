package com.ibm.demo.test.exercise.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Utils implements Comparable{
	
	public static <T> void sort(List<T> list, Comparator com){
		Object[] a=list.toArray();
		sort(a, com);
		for(int i=0;i<a.length;i++){
			list.set(i, (T)a[i]);
		}
	}

	// 数组的排序（降序）+Comparator接口
	public static void sort(Object[] a, Comparator com) {
		boolean sorted = true;
		for (int j = 0; j < a.length - 1; j++) {
			sorted = true;
			System.out.println("第" + (j + 1) + "趟");
			for (int i = 0; i < a.length - j - 1; i++) {
				System.out.print("第" + (i + 1) + "次");
				if (com.compare(a[i], a[i+1])<0) {
					Object temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					sorted = false;
				}
				System.out.println(Arrays.toString(a));
			}
			if (sorted == true) {
				break;
			}
		}
	}
	
	// 数组的排序（降序）+Comparator接口
	public static void sort(Object[] a) {
		boolean sorted = true;
		for (int j = 0; j < a.length - 1; j++) {
			sorted = true;
			System.out.println("第" + (j + 1) + "趟");
			for (int i = 0; i < a.length - j - 1; i++) {
				System.out.print("第" + (i + 1) + "次");
				if (((Comparable) a[i]).compareTo((Comparable) a[i + 1]) < 0) {
					Object temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
					sorted = false;
				}
				System.out.println(Arrays.toString(a));
			}
			if (sorted == true) {
				break;
			}
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
