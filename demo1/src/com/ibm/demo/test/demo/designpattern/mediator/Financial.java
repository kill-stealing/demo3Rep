package com.ibm.demo.test.demo.designpattern.mediator;

public class Financial implements Department{
	
	private Mediator m; //持有中介者
	
	public Financial(Mediator m) {
		super();
		this.m = m;
		m.register("financial", this);
	}

	@Override
	public void selfAction() {
		System.out.println("数钱！");
	}

	@Override
	public void outAction() {
		System.out.println("汇报工作，钱太多了，怎么花？");
		
	}

}
