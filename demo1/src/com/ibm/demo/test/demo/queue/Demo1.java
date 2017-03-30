package com.ibm.demo.test.demo.queue;

import java.util.ArrayDeque;
import java.util.Queue;


public class Demo1 {
	public static void main(String[] args) {
		Queue<Request> queue=new ArrayDeque<Request>();
		//模拟排队情况
		for (int i = 0; i < 10; i++) {
			final int num=i;
			queue.offer(new Request() {
				@Override
				public void deposit() {
					System.out.println("第"+num+"个人，办理存款业务，存款额度为："+(Math.random()*10000));
				}
			});
		}
		
		dealWith(queue);
	}
	
	//处理业务
	public static void dealWith(Queue<Request> que){
		Request req=null;
		while(null!=(req=que.poll())){
			req.deposit();
		}
	}
}

interface Request{
	void deposit();
}