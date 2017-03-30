package com.ibm.demo.test.demo.designpattern.factory.abstractfactory;

import java.lang.reflect.Method;

public class Client {
	public static void main(String[] args) throws Exception{
		/*CarFactory factory=new LuxuryCarFactory();
		Engine e=factory.createEngine();
		e.run();
		e.start();
		
		Class<?> clz=Client.class;*/
		
		
		Class<?> clz=Class.forName("com.ibm.demo.test.demo.designpattern.factory.abstractfactory.LuxuryEngine");
		Object o=clz.newInstance();
		Method m=clz.getDeclaredMethod("run", null);
		m.invoke(o, null);
	}
}
