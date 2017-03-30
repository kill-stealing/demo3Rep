package com.ibm.demo.test.demo.designpattern.factory.factorymethod;

import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Car;

/**
 * 简单工厂模式下
 * @author liumy
 *
 */
public class Client {	//调用者
	public static void main(String[] args) {
		Car c1=new AudiFactory().createCar();
		Car c2=new BydFactory().createCar();
		
		c1.run();
		c2.run();
	}
}
