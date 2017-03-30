package com.ibm.demo.test.threaddemo.xinhaodeng;

public class App1 {

	public static void main(String[] args) {
		Movie1 m=new Movie1();
		Player1 p1=new Player1(m);
		Watcher1 w1=new Watcher1(m);
		new Thread(p1).start();
		new Thread(w1).start();
	}

}
