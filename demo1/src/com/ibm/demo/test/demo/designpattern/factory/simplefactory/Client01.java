package com.ibm.demo.test.demo.designpattern.factory.simplefactory;

import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Audi;
import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Byd;
import com.ibm.demo.test.demo.designpattern.factory.factorymethod.Car;

/**
 * 测试在没有工厂模式的情况下
 * @author liumy
 *
 */
public class Client01 {	//调用者
	public static void main(String[] args) {
		Car c1=new Audi();
		Car c2=new Byd();
		
		c1.run();
		c2.run();
	}
}
