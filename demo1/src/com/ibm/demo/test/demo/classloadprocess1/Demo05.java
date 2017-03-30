package com.ibm.demo.test.demo.classloadprocess1;

public class Demo05 {
	public static void main(String[] args) throws Exception {
		ClassLoader loader = Demo05.class.getClassLoader();
		System.out.println(loader);
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		Thread.currentThread().setContextClassLoader(
				new FileSystemClassLoader("C:/myJava"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		Class<Demo02> c = (Class<Demo02>) Thread.currentThread().getContextClassLoader()
				.loadClass("com.ibm.demo.test.demo.classloadprocess1.Demo02");
		System.out.println(c);
		System.out.println(c.getClassLoader());
	}
}
