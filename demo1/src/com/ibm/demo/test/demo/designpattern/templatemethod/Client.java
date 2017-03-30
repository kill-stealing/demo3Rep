package com.ibm.demo.test.demo.designpattern.templatemethod;

public class Client {
	public static void main(String[] args) {
		BankTemplateMethod b=new DrawMoney();
		b.process();
		
		BankTemplateMethod b1=new BankTemplateMethod() {
			
			@Override
			public void transact() {
				
			}
		};
		
		b1.process();
	}
}

class DrawMoney extends BankTemplateMethod{

	@Override
	public void transact() {
		System.out.println("我要取款！！！");
	}
	
}