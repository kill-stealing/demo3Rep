package com.ibm.demo.test.demo.zijilianxi.thread.pro;
/**
 * wait 
 * @author liumy
 *
 */
public class Movie {
	private String pic;
	//信号灯 
	//flag为true 生产者生产 消费者等待，生产完成后通知消费
	//flag为false 消费者消费 生产者等待，消费完成后通知生产
	private boolean flag=true;
	public synchronized void play(String pic){
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("生产了："+pic);
		//生产完毕
		this.pic=pic;
		//通知消费
		this.notify();
		//生产者停下
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
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("消费了："+pic);
		//通知生产
		this.notify();
		//消费者停止
		this.flag=true;
	}
}
