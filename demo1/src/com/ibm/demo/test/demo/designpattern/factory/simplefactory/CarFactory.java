package com.ibm.demo.test.demo.designpattern.factory.simplefactory;

import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Audi;
import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Byd;
import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Car;

public class CarFactory {
	public static Car createCar(String type){
		if("奥迪".equals(type)){
			return new Audi();
		}else if("比亚迪".equals(type)){
			return new Byd();
		}else{
			return null;
		}
	}
}
