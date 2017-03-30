package com.ibm.demo.test.io.pattern;

public class Voice {
	private int voice=10;
	public Voice(){
		
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	public void say(){
		System.out.println(voice);
	}
}
