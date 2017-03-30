package com.ibm.demo.test.demo.designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Star realStar=new RealStar();
		
		StarHandler handler=new StarHandler(realStar);
		
		Star proxy=(Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
		System.out.println(proxy.getClass().getName());
		proxy.sing();
		proxy.bookTicket();
	}
}
