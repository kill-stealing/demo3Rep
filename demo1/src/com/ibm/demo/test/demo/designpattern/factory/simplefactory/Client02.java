package com.ibm.demo.test.demo.designpattern.factory.simplefactory;

import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Car;

/**
 * 简单工厂模式下
 * @author liumy
 *
 */
public class Client02 {	//调用者
	public static void main(String[] args) {
		Car c1=CarFactory.createCar("奥迪");
		Car c2=CarFactory.createCar("比亚迪");
		
		c1.run();
		c2.run();
	}
}
