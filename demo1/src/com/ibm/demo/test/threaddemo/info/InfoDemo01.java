package com.ibm.demo.test.threaddemo.info;
/**
 * Thread.currentThread();
 * setName()
 * getName()
 * isAlive()
 * @author liumy
 *
 */
public class InfoDemo01 {
	public static void main(String[] args) {
		MyThread t1=new MyThread();
		Thread proxy=new Thread(t1,"IT");
		proxy.setName("test");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		proxy.start();
		System.out.println("启动后的状态"+proxy.isAlive());
		try {
			proxy.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.stop();
		System.out.println("停止后的状态"+proxy.isAlive());
		System.out.println("停止后的状态"+proxy.isAlive());
		System.out.println("停止后的状态"+proxy.isAlive());
	}
}
