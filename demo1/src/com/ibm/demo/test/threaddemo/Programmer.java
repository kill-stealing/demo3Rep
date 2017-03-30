package com.ibm.demo.test.threaddemo;

import sun.tools.jar.resources.jar;

/**
 * 使用runnable 接口创建线程
 * 1.类实现Runnable 接口+重写 run() -->真实角色类
 * 2.启动多线程 使用静态代理
 * 		 1.真实角色
 * 		 2.代理角色： 持有真实角色的引用
 * 	     3.二者 实现相同的接口
 * 		 4.调用start() 启动线程
 * @author liumy
 *
 */
public class Programmer implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("一边敲helloworld"+i);
		}
	}
	
}
