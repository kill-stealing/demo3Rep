package com.ibm.demo.test.demo.designpattern.observer;

public class Client {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject cs=new ConcreteSubject();
		//创建多个观察者
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		ObserverA obs3=new ObserverA();
		
		//将三个观察者添加到subject对象的观察队伍中
		cs.register(obs1);
		cs.register(obs2);
		cs.register(obs3);
		
		//改变subject的状态
		cs.setState(3000);
		System.out.println("#########################");
		//查看观察者的状态是不是也发生了变化
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		//改变subject的状态
		cs.setState(1);
		System.out.println("#########################");
		//查看观察者的状态是不是也发生了变化
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
}
