package com.ibm.demo.test.demo.zijilianxi.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableTest {

	public static void main(String[] args) {
		String abc="";
		abc.contains("dd");
		//创建线程
		ExecutorService ser=Executors.newFixedThreadPool(2);
		Race tortoise =new Race("乌龟",1000);
		Race rabbit =new Race("小兔子",500);
		//获取值
		Future<Integer> tRes=ser.submit(tortoise);
		Future<Integer> rRes=ser.submit(rabbit);
		try {
			Thread.sleep(2000);
			tortoise.setFlag(false);
			rabbit.setFlag(false);
			int num1=tRes.get();
			System.out.println(num1);
			int num2=rRes.get();
			System.out.println(num2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Race implements Callable<Integer>{
	private int step=0;
	private long time;
	private boolean flag=true;
	private String name;
	
	public Race() {
		// TODO Auto-generated constructor stub
	}
	
	public Race(String name,long time){
		this.name=name;
		this.time=time;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer call() throws Exception {
		while(flag){
			Thread.sleep(time);
			System.out.println(Thread.currentThread().getName()+"-->"+(step++));
		}
		return step;
	}
	
}