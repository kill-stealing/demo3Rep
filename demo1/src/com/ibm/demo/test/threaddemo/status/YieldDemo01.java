package com.ibm.demo.test.threaddemo.status;

public class YieldDemo01 extends Thread{
	public static void main(String[] args) {
		YieldDemo01 j1=new YieldDemo01();
		Thread t1=new Thread(j1);
		t1.start();
		
		for (int i = 0; i < 1000; i++) {
			if(i%20==0){
				Thread.yield();
			}
			System.out.println("main..."+i);
		}
	
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("yield..."+i);
		}
	}
}
