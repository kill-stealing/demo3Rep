package com.ibm.demo.test.demo.designpattern.factory.abstractfactory;

public class LuxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new LuxurySeat();
	}

	@Override
	public Tyre createTyre() {
		// TODO Auto-generated method stub
		return new LuxuryTyre();
	}
	
}
