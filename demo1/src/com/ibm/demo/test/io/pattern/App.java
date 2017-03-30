package com.ibm.demo.test.io.pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Voice voice=new Voice();
		voice.say();
		Amplifier amplifier=new Amplifier(voice);
		amplifier.say();
	}

}
