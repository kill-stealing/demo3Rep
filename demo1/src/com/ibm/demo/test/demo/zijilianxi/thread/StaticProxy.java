package com.ibm.demo.test.demo.zijilianxi.thread;

public class StaticProxy {
	public static void main(String[] args) {
		B b=new B();
		C c=new C(b);
		c.marry();
	}
}

interface A{
	void marry();
}
class B implements A{

	@Override
	public void marry() {
		System.out.println("B 和 嫦娥结婚了");
	}
}
class C implements A{
	B b;
	public C(B b){
		this.b=b;
	}
	
	public C(){
		
	}
	
	public void before(){
		System.out.println("c before");
	}

	@Override
	public void marry() {
		before();
		b.marry();
		after();
	}
	
	public void after(){
		System.out.println("c after");
	}
	
}