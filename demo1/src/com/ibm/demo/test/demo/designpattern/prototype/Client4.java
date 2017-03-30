package com.ibm.demo.test.demo.designpattern.prototype;

public class Client4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		testNew(1000);
		testClone(1000);
	}
	
	public static void testNew(int size){
		long start=System.currentTimeMillis();
		for(int i=0;i<size;i++){
			Laptop laptop=new Laptop();
		}
		long end=System.currentTimeMillis();
		System.out.println("new 方式耗时："+(end-start));
	}
	
	public static void testClone(int size) throws CloneNotSupportedException{
		long start=System.currentTimeMillis();
		Laptop laptop=new Laptop();
		for(int i=0;i<size;i++){
			Laptop temp=(Laptop) laptop.clone();
		}
		long end=System.currentTimeMillis();
		System.out.println("clone 方式耗时："+(end-start));
	}
	
}

class Laptop implements Cloneable{
	public Laptop(){
		try {
			Thread.sleep(10);	//模拟创建对象的耗时过程
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();//直接调用object对象的clone方法
		return obj;
	}
}
