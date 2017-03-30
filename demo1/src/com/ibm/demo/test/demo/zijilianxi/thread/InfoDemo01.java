package com.ibm.demo.test.demo.zijilianxi.thread;

public class InfoDemo01 {

	public static void main(String[] args) {
		MyThread m1=new MyThread();
		Thread t1=new Thread(m1);
		t1.start();
	}

}
