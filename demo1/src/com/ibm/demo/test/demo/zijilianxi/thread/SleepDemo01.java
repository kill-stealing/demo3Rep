package com.ibm.demo.test.demo.zijilianxi.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepDemo01{

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		SleepDemo01 d=new SleepDemo01();
		Thread t=new Thread(d);
		t.start();*/
		Date endTime=new Date(System.currentTimeMillis()+10*1000);
		long end=endTime.getTime();
		while(true){
			try {
				System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
				Thread.sleep(1000);
				endTime=new Date(endTime.getTime()-1000);
				/*System.out.println(new Date(time-10000).compareTo(d));
				if((new Date(time-10000).compareTo(d))==0){
					break;
				}*/
				
				if(end-10000>endTime.getTime()){
						break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void test1(){
		for(int i=10;i>=0;i--){
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*@Override
	public void run() {
		for(int i=10;i>=0;i--){
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	

}
