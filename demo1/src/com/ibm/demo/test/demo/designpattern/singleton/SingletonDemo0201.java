package com.ibm.demo.test.demo.designpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 测试懒汉式单例模式(如何防止反射和反序列化漏洞)
 * @author liumy
 *
 */
public class SingletonDemo0201 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//类初始化时，立即加载这个对象（没有延时加载的优势） !由于加载类时，天然的是线程安全的
	private static SingletonDemo0201 instance;
	
	private SingletonDemo0201(){
		if(instance!=null){
			throw new RuntimeException();
		}
	}
	
	public static synchronized SingletonDemo0201 getInstance(){
		if(null==instance){
			instance=new SingletonDemo0201();
		}
		return instance;
	}
	
	//反序列化时，如果定义了readRessolve方法，则直接调用这个方法，而不需要把反序列的新对象返回
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
	
}
