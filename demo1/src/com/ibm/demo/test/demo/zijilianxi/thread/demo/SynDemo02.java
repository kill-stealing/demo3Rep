package com.ibm.demo.test.demo.zijilianxi.thread.demo;

public class SynDemo02 {

	public static void main(String[] args) {
		/*Jvm j1=Jvm.getInstance();
		Jvm j2=Jvm.getInstance();
		System.out.println(j1);
		System.out.println(j2);*/
		
		JvmThread j1=new JvmThread(100L);
		JvmThread j2=new JvmThread(500L);
		j1.start();
		j2.start();
	}
}

class JvmThread extends Thread{
	private long time;
	
	public JvmThread() {
		
	}
	
	public JvmThread(long time) {
		this.time=time;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->创建："+Jvm.getInstance3(time));
	}
}


class Jvm {
	private static Jvm instance=null;
	private Jvm(){
		
	}
	
	public static Jvm  getInstance4(long time){
		if(null==instance){
			synchronized(Jvm.class){
				if(null==instance){
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					instance=new Jvm();
				}
			}
		}
		return instance;
	}
	
	public static Jvm  getInstance3(long time){
		synchronized(Jvm.class){
			if(null==instance){
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance=new Jvm();
			}
			return instance;
		}
	}
	
	public static synchronized Jvm  getInstance2(long time){
		if(null==instance){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance=new Jvm();
		}
		return instance;
	}
	
	public static  Jvm  getInstance1(long time){
		if(null==instance){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance=new Jvm();
		}
		return instance;
	}
}
