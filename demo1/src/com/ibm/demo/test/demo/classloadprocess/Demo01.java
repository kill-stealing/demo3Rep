package com.ibm.demo.test.demo.classloadprocess;

public class Demo01 {
	
	static{
		System.out.println("静态初始化Demo01");
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Demo01中的main方法");
		A a=new A();
		//主动引用
//		new A();
//		System.out.println(A.width);
		Class.forName("com.ibm.demo.test.demo.classloadprocess.A");
		//被动引用
//		System.out.println(A.MAX);
		A[] as=new A[10];
	}

}

class B extends A{
	static{
		System.out.println("静态初始化B");
	}
}

class A extends A_Father{
	public static int width=100;
	public static final int MAX=100;
	static{
		System.out.println("静态初始化类A");
		width=300;
	}
	public A(){
		System.out.println("创建A类的对象");
	}
}

class A_Father{
	static{
		System.out.println("静态初始化A_Father");
	}
}