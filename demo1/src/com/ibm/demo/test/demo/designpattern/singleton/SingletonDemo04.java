package com.ibm.demo.test.demo.designpattern.singleton;
/**
 * 测试枚举实现单例模式（没有延时加载）
 * @author liumy
 *
 */
public enum SingletonDemo04 {
	
	//这个枚举元素，本身就是单例对象
	INSTANCE;
	
	//添加自己需要的操作
	public void singletonOperation(){
		
	}
}
