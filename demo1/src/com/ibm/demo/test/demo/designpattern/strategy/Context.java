package com.ibm.demo.test.demo.designpattern.strategy;
/**
 * 负责和具体的策略类交互
 * 这样的话，具体的算法和直接的客户端调用分离了，使得算法可以独立于客户端独立的变化。
 * @author liumy
 *
 */
public class Context {
	private Strategy strategy; //当前采用的算法

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void printPrice(double s){
		System.out.println("您该报价："+strategy.getPrice(s));
	}
}
