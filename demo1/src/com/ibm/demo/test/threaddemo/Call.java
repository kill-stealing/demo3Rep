package com.ibm.demo.test.threaddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
/**
 * 使用Callable创建线程
 * @author liumy
 *
 */
public class Call {
	public static void main(String[] args) {
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
	private String name;
	private long time;//延时
	private boolean flag=true;
	private int step=0;//步
	public Race(){
		
	}
	
	public Race(String name) {
		super();
		this.name = name;
	}
	
	public Race(String name,long time) {
		this(name);
		this.time=time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Override
	public Integer call() throws Exception {
		while(flag){
			Thread.sleep(time);//延时
			step++;
			System.out.println(this.getName()+step);
		}
		return step;
	}
	
}