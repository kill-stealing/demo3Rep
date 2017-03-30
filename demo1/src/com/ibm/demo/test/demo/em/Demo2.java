package com.ibm.demo.test.demo.em;

import java.util.StringTokenizer;

public class Demo2 {
	public static void main(String[] args) {
		String emailString="bjsxt@163.com;bjsxt@qq.com;bjsxt@sohu.com";
		StringTokenizer tokenizer=new StringTokenizer(emailString,";");
		while (tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextElement());
		}
	}
}
