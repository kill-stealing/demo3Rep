package com.ibm.demo.test;


public class Student {
	int a;
	
	static int c;
	int b;
	public Student(){
		
	}
	
	
	
	public Student(int a,int b,int c){
		this();
		this.study();
		this.c=c;
		this.a=a;
		this.b=b;
	}
	
	public final void  study(){
		
	}
	
	public final void  study(int a){
		
	}
	
	public static void main(String[] args) {
		Object object=new Object();
		Student student=new Student();
		student.c=1;
		System.out.println(object.toString());
	}
}
