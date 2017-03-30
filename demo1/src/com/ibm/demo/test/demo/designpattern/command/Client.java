package com.ibm.demo.test.demo.designpattern.command;

public class Client {
	public static void main(String[] args) {
		Command c=new ConcreteCommand(new Receiver());
		Invoke invoke=new Invoke(c);
		invoke.call();
	}
}
