package com.ibm.demo.test.demo.designpattern.singleton;
/**
 * 测试懒汉式单例模式
 * @author liumy
 *
 */
public class SingletonDemo02 {
	//类初始化时，立即加载这个对象（没有延时加载的优势） !由于加载类时，天然的是线程安全的
	private static SingletonDemo02 instance;
	
	private SingletonDemo02(){
		
	}
	
	public static synchronized SingletonDemo02 getInstance(){
		if(null==instance){
			instance=new SingletonDemo02();
		}
		return instance;
	}
	
	
}
