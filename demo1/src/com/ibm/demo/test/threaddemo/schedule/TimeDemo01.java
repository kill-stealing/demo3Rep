package com.ibm.demo.test.threaddemo.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 了解
 * Timer()
 * schedule(TimerTask task,Date time)
 * schedule(TimerTask task,Date first time,long period)
 * 自学quartz
 * @author liumy
 *
 */
public class TimeDemo01 {

	public static void main(String[] args) {
		Timer  timer=new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("so easy ...");
			}
		}, new Date(System.currentTimeMillis()+1000), 200);
	}

}
