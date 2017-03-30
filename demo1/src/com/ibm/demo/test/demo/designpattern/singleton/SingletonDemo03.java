package com.ibm.demo.test.demo.designpattern.singleton;
/**
 * 测试静态内部类实现单例模式
 * 这种方式：线程安全，调用效率高，并且实现了延时加载
 * @author liumy
 *
 */
public class SingletonDemo03 {
	private static class SingletonClassInstance{
		private static final SingletonDemo03 instance=new SingletonDemo03();
	}
	
	private SingletonDemo03(){
		
	}
	
	public static synchronized SingletonDemo03 getInstance(){
		return SingletonClassInstance.instance;
	}
	
	
}
