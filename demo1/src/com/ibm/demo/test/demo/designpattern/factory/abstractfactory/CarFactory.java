package com.ibm.demo.test.demo.designpattern.factory.abstractfactory;

public interface CarFactory {
	Engine createEngine();
	Seat createSeat();
	Tyre createTyre();
}
