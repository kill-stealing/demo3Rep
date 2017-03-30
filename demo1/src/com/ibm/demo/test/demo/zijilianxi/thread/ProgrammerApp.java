package com.ibm.demo.test.demo.zijilianxi.thread;

public class ProgrammerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Programmer p=new Programmer();
		Thread t=new Thread(p);
		t.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("main----> "+i);
		}
	}

}
