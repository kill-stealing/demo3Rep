package com.ibm.demo.test.demo.designpattern.mediator;

public class Development implements Department{
	
	private Mediator m; //持有中介者
	
	public Development(Mediator m) {
		super();
		this.m = m;
		m.register("development", this);
	}

	@Override
	public void selfAction() {
		System.out.println("专心科研开发项目");
	}

	@Override
	public void outAction() {
		System.out.println("汇报工作，没钱了，需要资金支持");
		
	}

}
