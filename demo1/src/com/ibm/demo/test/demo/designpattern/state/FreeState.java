package com.ibm.demo.test.demo.designpattern.state;

public class FreeState implements State{

	@Override
	public void handle() {
		System.out.println("房间空闲！！没人住！");
	}

}
