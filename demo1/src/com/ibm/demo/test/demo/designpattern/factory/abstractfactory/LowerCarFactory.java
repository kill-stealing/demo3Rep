package com.ibm.demo.test.demo.designpattern.factory.abstractfactory;

public class LowerCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LowerEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new LowerSeat();
	}

	@Override
	public Tyre createTyre() {
		// TODO Auto-generated method stub
		return new LowerTyre();
	}
	
}
