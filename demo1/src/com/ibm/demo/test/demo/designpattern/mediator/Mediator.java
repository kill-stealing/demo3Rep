package com.ibm.demo.test.demo.designpattern.mediator;

public interface Mediator {
	
	void register(String name,Department d);
	
	void command(String dName);
	
}
