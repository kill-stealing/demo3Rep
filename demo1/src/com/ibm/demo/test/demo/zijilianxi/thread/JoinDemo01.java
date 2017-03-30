package com.ibm.demo.test.demo.zijilianxi.thread;

public class JoinDemo01 extends Thread{

	public static void main(String[] args) {
		JoinDemo01 d1=new JoinDemo01();
		Thread t=new Thread(d1);
		t.start();
		
		for(int i=0;i<1000;i++){
			if(i==50){
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("main...-->"+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("join...-->"+i);
		}
	}
}
