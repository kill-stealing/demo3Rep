package com.ibm.demo.test.demo.sort.bubble;

import java.util.Arrays;
import java.util.Date;

public class BubbleDemo1 {
	public static void main(String[] args) {
		int[] a={9,8,7,6,5};
		sortFirst(a);
		System.out.println("------------final--------");
		a=new int[]{1,2,9,3,4};
		String[] aString=new String[]{"abb","bb","fdsaf","fdsf"};
		sortFirst(a);
		Date date=new Date();
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
		
		
		/*System.out.println("第二趟");
		for (int i = 0; i < a.length-1; i++) {
			System.out.print("第"+(i+1)+"次");
			if(a[i]>a[i+1]){
				int temp=a[i+1];
				a[i+1]=a[i];
				a[i]=temp;
			}
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println("第三趟");
		for (int i = 0; i < a.length-1; i++) {
			System.out.print("第"+(i+1)+"次");
			if(a[i]>a[i+1]){
				int temp=a[i+1];
				a[i+1]=a[i];
				a[i]=temp;
			}
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println("第四趟");
		for (int i = 0; i < a.length-1; i++) {
			System.out.print("第"+(i+1)+"次");
			if(a[i]>a[i+1]){
				int temp=a[i+1];
				a[i+1]=a[i];
				a[i]=temp;
			}
			System.out.println(Arrays.toString(a));
		}*/
		
		
		/*i++;
		System.out.println("第"+(i+1)+"次");
		if(a[i]>a[i+1]){
			int temp=a[i+1];
			a[i+1]=a[i];
			a[i]=temp;
		}
		System.out.println(Arrays.toString(a));
		
		i++;
		System.out.println("第"+(i+1)+"次");
		if(a[i]>a[i+1]){
			int temp=a[i+1];
			a[i+1]=a[i];
			a[i]=temp;
		}
		System.out.println(Arrays.toString(a));
		
		i++;
		System.out.println("第"+(i+1)+"次");
		if(a[i]>a[i+1]){
			int temp=a[i+1];
			a[i+1]=a[i];
			a[i]=temp;
		}
		System.out.println(Arrays.toString(a));*/
	}
}
