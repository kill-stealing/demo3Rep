package com.ibm.demo.test.demo.internalclass;

import java.util.Date;

public class Demo03 {
	
	final static Date d=new Date();
	
		public static void main(String[] args) {
			Outer03 o=new Outer03();
			Outer03.InnerClass i=o.new InnerClass();
			i.test();
		}
}

class Outer03{
	
	private int a=3;
	int b=10;
	
	//成员内部类
	class InnerClass{
		
		int c=1;
//		final static  int d=1;			//成员内部类不能有静态成员 ，除非声明为final，并且只能是编译器可以确定值的常量表达式
//		final static Date d2=new Date();
		
//		static InnerClass class1=new InnerClass(); //Outer03.InnerClass.class1 可以直接获得内部类对象，这时成员内部类对象
//		就完全脱离了外部类的控制，与设计成员内部类的初衷不一致。
		
		void test(){
			System.out.println(a);
			System.out.println("内部类对象："+this);//成员内部类对象的创建，必须先有外部类对象
			System.out.println("外部类对象："+Outer03.this);//引用了外部类的对象
		}
	}
	
	
}
