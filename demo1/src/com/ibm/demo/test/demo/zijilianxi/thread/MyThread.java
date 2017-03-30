package com.ibm.demo.test.demo.zijilianxi.thread;

public class MyThread implements Runnable{
	private boolean flag=true;
	private int num=0;
	

	@Override
	public void run() {
		while(flag){
			System.out.println(num++);
		}
		
	}
	
	public void stop(){
		this.flag=false;
	}

}
