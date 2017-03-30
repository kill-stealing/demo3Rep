package com.ibm.demo.test.demo.designpattern.factory.factorymethod;

public class BenciFactory implements CarFactory{

	@Override
	public Car createCar() {
		return new Benci();
	}

}
