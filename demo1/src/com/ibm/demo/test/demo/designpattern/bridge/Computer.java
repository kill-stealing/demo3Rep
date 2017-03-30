package com.ibm.demo.test.demo.designpattern.bridge;

public interface Computer {
	void sale();
}

class Desktop implements Computer{

	@Override
	public void sale() {
		System.out.println("销售台式机");
	}
	
}

class Laptop implements Computer{

	@Override
	public void sale() {
		System.out.println("销售笔记本");
	}
	
}

class Pad implements Computer{

	@Override
	public void sale() {
		System.out.println("销售平板电脑");
	}
}

class LenovoDesktop extends Desktop{
	@Override
	public void sale() {
		System.out.println("销售联想台式机");
	}
}

class LenovoLaptop extends Laptop{
	@Override
	public void sale() {
		System.out.println("销售联想笔记本");
	}
}

class LenovoPad extends Pad{
	@Override
	public void sale() {
		System.out.println("销售联想平板电脑");
	}
}

