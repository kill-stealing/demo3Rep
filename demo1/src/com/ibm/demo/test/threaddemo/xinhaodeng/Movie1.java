package com.ibm.demo.test.threaddemo.xinhaodeng;

public class Movie1 {
	
	private String pic;
	
	private boolean flag=true;
	
	public synchronized void play(String pic){
		//如果flag是false 则 生产者等待
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//生产者生产
		System.out.println("生产了："+pic);
		//生产完毕
		this.pic=pic;
		//唤醒消费者消费
		this.notify();
		this.flag=false;
	}
	public synchronized void watch(){
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("消费了："+this.pic);
		this.notify();
		this.flag=true;
	}
}
