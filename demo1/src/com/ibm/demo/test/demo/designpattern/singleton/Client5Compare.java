package com.ibm.demo.test.demo.designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试
 * 
 * @author liumy
 *
 */
public class Client5Compare {

	public static void main(String[] args) throws Exception{

		long startTime=System.currentTimeMillis();
		
		int threadNum=10;
		final CountDownLatch countDownLatch=new CountDownLatch(threadNum);
		
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 1000000; i++) {
						Object o = SingletonDemo04.INSTANCE;
					}
					
					countDownLatch.countDown();
				}
			}).start();
		}
		
		countDownLatch.await();
		
		long end=System.currentTimeMillis();
		System.out.println("总耗时："+(end-startTime));
	}

}
