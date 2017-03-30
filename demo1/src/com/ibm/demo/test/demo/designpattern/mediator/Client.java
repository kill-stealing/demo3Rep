package com.ibm.demo.test.demo.designpattern.mediator;

public class Client {
	public static void main(String[] args) {
		Mediator m=new President();
		Market market=new Market(m);
		Development dev=new Development(m);
		Financial financial=new Financial(m);
		
		market.selfAction();
		market.outAction();
		
	}
}
