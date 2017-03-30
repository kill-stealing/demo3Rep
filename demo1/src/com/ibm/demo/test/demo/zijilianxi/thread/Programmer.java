package com.ibm.demo.test.demo.zijilianxi.thread;

public class Programmer implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("hello world----> "+i);
		}
		
	}

}
