package com.ibm.demo.test.threaddemo.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 * 1.倒数10个数，一秒内打印一个
 * @author liumy
 *
 */
public class SleepDemo01 {
	public static void main(String[] args) throws InterruptedException {
		Date endTime=new Date(System.currentTimeMillis()+10*1000);
		long end=endTime.getTime();
		while(true){
			//
			Thread.sleep(1000);
			//输出
			System.out.println(new SimpleDateFormat("HH:mm:ss").format(endTime));
			//构建下一秒时间
			endTime=new Date(endTime.getTime()-1000);
			//在10秒以内 继续 否则退出
			if(end-10000>endTime.getTime()){
				break;
			}
		}
		
	}
	
	public static void test1() throws InterruptedException{
		int num=10;
		while(true){
			System.out.println(num--);
				Thread.sleep(1000);
			if(num<=0){
				break;
			}
		}
	
	}
	
	public static void test2(){
		int num=10;
		while(true){
			System.out.println(num--);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(num<=0){
				break;
			}
		}
	
	}
}
