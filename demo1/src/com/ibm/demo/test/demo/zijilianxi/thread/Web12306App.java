package com.ibm.demo.test.demo.zijilianxi.thread;

public class Web12306App {

	public static void main(String[] args) {
		Web12306 w=new Web12306(20);
		Thread t1=new Thread(w,"t1");
		Thread t2=new Thread(w,"t2");
		Thread t3=new Thread(w,"t3");
		t1.start();
		t2.start();
		t3.start();
	}

}
