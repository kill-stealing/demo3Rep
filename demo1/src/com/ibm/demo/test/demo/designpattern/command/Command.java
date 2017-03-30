package com.ibm.demo.test.demo.designpattern.command;

public interface Command {
	/**
	 * 这个方法是一个返回结果为空的方法
	 */
	void excute();
}

class ConcreteCommand implements Command{
	//命令的真正的执行者
	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void excute() {
		receiver.action();
	}
	
}