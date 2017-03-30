package com.ibm.demo.test.threaddemo.xinhaodeng;

public class Player1 implements Runnable{
	private Movie1 m;
	

	public Player1(Movie1 m) {
		super();
		this.m = m;
	}


	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(0==i%2){
				m.play("左青龙");
			}else{
				m.play("右白虎");
			}
		}
	}

}
