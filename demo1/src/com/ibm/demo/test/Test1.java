package com.ibm.demo.test;

import java.io.Closeable;
import java.io.IOException;

public class Test1 {

	public static <T> void test(T t) {
		System.out.println(t);
	}

	public static void main(String[] args) {
		test(new Test22().a);
	}

	public static <T extends Closeable> void test(T... a) {
		for (T temp : a) {
			try {
				if (null != temp) {
					temp.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Test22{
	public String a;
}
