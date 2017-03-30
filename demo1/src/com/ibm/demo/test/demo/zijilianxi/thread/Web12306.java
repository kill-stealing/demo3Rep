package com.ibm.demo.test.demo.zijilianxi.thread;

public class Web12306 implements Runnable{
	
	public int trainTicket;
	public Web12306() {
		
	}
	
	public Web12306(int trainTicket) {
		this.trainTicket=trainTicket;
	}
	
	@Override
	public void run() {
		while(trainTicket>0){
			System.out.println(Thread.currentThread().getName()+"-->"+trainTicket);
			trainTicket--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
