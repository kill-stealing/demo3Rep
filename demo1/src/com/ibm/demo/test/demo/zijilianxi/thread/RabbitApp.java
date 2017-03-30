package com.ibm.demo.test.demo.zijilianxi.thread;

public class RabbitApp {

	public static void main(String[] args) {
		RabbitTest r=new RabbitTest();
		Tortoise t=new Tortoise();
		r.start();
		t.start();
		
		for(int i=0;i<100;i++){
			System.out.println("main 方法跑了"+i+"步");
		}
	}

}
