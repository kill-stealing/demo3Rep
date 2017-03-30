package com.ibm.demo.test.threaddemo.xinhaodeng;

public class Watcher1 implements Runnable{
	private Movie1 m;
	
	public Watcher1(Movie1 m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			m.watch();
		}
	}

}
