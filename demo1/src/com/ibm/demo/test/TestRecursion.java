package com.ibm.demo.test;

public class TestRecursion {
	int b;
	public static int add(int a){
		if(a==1){
			return 1;
		}else{
			System.out.println("a "+a);
			return a*add(a-1);
		}
	}
	
	public TestRecursion(int b){
		this.b=b;
	}
	
	public void test11(){
		
	}
	
	public static void main(String[] args) {
		System.out.println(add(4));
	}
}
