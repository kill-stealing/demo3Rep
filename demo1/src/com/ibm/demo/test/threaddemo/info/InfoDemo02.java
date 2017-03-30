package com.ibm.demo.test.threaddemo.info;
/**
 * 优先级 概率 不是绝对的优先级
 * MAX_PRIORITY
 * NORM_PRIORITY
 * MIN_PRIORITY
 * 
 * setPriority
 * getPriority
 * @author liumy
 *
 */
public class InfoDemo02 {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1=new MyThread();
		Thread p1=new Thread(t1,"线程1");
		MyThread t2=new MyThread();
		Thread p2=new Thread(t2,"线程线程2");
		p1.setPriority(Thread.MIN_PRIORITY);//设置优先级
		p2.setPriority(Thread.MAX_PRIORITY);//设置优先级
		p1.start();
		p2.start();
		Thread.sleep(100);
		t1.stop();
		t2.stop();
	}

}
