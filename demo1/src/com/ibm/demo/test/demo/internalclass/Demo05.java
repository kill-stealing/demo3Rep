package com.ibm.demo.test.demo.internalclass;

public class Demo05 {
	
	public static void main(String[] args) {
		Outer05 out=new Outer05();
		out.test();
	}
}

class Outer05{
	
	public void test02(Car c){
		c.run();
	}
	
	public void test(){
		
		//匿名内部类(接口式)
		Runnable run=new Runnable() {
			@Override
			public void run() {
				
			}
		};
		
		//匿名内部类，继承式
		Car car=new Car(){
			@Override
			public void run() {
				System.out.println("子类的车跑");
			}
		};
		car.run();
		test02(new Car(){
			@Override
			public void run() {
				System.out.println("参数式匿名内部类，车在跑");
			}
		});
	}
	
}

class Car{
	public void run(){
		System.out.println("汽车跑");
	}
}