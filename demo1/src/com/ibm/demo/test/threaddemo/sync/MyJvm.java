package com.ibm.demo.test.threaddemo.sync;
/**
 * 单例创建的方式
 * 一.懒汉式
	 * 1.构造器私有化,避免外部直接创建对象
	 * 2.声明一个私有的静态变量
	 * 3.创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象

 * @author liumy
 *
 */
public class MyJvm {
	private static MyJvm instance;
	private MyJvm(){
		
	}
	public static MyJvm getInstance(){
		if(null==instance){
			synchronized (MyJvm.class) {
				if(null==instance){
					instance=new MyJvm();
				}
			}
		}
		return instance;
	}
}

/**
 *  * 二.饿汉式
	 * 1.构造器私有化,避免外部直接创建对象
	 * 2.声明一个私有的静态变量,同时创建该对象
	 * 3.创建一个对外的公共的静态方法 访问该变量
 * @author liumy
 *
 */

class MyJvm2 {
	private static MyJvm2 instance=new MyJvm2();
	private MyJvm2(){
		
	}
	public static MyJvm2 getInstance(){
		return instance;
	}
}

/**
 * 类在使用的时候加载，延缓加载的时间
 * @author liumy
 *
 */
class MyJvm3 {
	private static class MyJvmHolder{
		private static MyJvm3 instance=new MyJvm3();
	}
	
	private MyJvm3(){
		
	}
	public static MyJvm3 getInstance(){
		return MyJvmHolder.instance;
	}
}
