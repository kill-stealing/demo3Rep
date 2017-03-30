package com.ibm.demo.test.demo.designpattern.strategy;

public class NewCustomerManyStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("不打折 原价");
		return standardPrice;
	}

}
