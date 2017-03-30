package com.ibm.demo.test.demo.designpattern.templatemethod;

public abstract class BankTemplateMethod {
	public void takeNumber(){
		System.out.println("取号排队");
	}
	
	public abstract void transact();//办理具体的业务
	
	public void evaluate(){
		System.out.println("反馈评分");
	}
	
	public final void process(){
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}
