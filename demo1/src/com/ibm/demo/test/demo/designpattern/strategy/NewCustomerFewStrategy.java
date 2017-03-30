package com.ibm.demo.test.demo.designpattern.strategy;

public class NewCustomerFewStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打九折");
		return standardPrice*0.9;
	}

}
