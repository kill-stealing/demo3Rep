package com.ibm.demo.test.demo.pro;

import java.io.IOException;
import java.util.Properties;

public class Demo04 {
	public static void main(String[] args) throws IOException {
		Properties properties=new Properties();
		//下面两种方式 用不用/ 表示的路径是不同的
		// / 类相对路径的  / bin  这里的/是bin目录
		properties.load(Demo04.class.
				getResourceAsStream("/com/ibm/demo/test/demo/pro/db.properties"));
		// 这里"" 相当于bin目录 
		//		properties.load(Thread.currentThread().
//				getContextClassLoader().
//				getResourceAsStream("com/ibm/demo/test/demo/pro/db.properties"));
		System.out.println(properties.getProperty("user","test"));
	}
}
