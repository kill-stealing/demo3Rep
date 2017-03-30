package com.ibm.demo.test.demo.zijilianxi.reflect;

import com.ibm.demo.test.demo.zijilianxi.net.server.demo01.CloseUtil;

public class Demo02 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class<?> clz = Class
		.forName("com.ibm.demo.test.demo.zijilianxi.net.server.demo01.CloseUtil");
		CloseUtil clo=(CloseUtil)clz.newInstance();
		if(clo instanceof CloseUtil){
			System.out.println(true);
		}
	}

}
