package com.ibm.demo.test.demo.zijilianxi.thread;

public class YieldDemo01 extends Thread{

	public static void main(String[] args) {
		YieldDemo01 d1=new YieldDemo01();
		Thread t=new Thread(d1);
		t.start();
		
		for(int i=0;i<1000;i++){
			if(i%20==0){
				Thread.yield();
			}
			System.out.println("main...-->"+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("yield...-->"+i);
		}
	}

}
