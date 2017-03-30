package com.ibm.demo.test.threaddemo.status;


/**
 * sleep 模拟网络延时
 * @author liumy
 *
 */
public class SleepDemo02 {
	public static void main(String[] args) {
		Web12306 web=new Web12306();
		Thread t1=new Thread(web,"路人甲");
		Thread t2=new Thread(web,"黄牛已");
		Thread t3=new Thread(web,"工程师");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
class Web12306 implements Runnable{
	
	private int num=50;
	
	@Override
	public void run() {
		while(true){
			if(num<=0){
				break;//跳出循环
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
		}
	}
	
}