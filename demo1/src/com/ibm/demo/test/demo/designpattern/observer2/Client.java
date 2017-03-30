package com.ibm.demo.test.demo.designpattern.observer2;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject cs=new ConcreteSubject();
		
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		ObserverA obs3=new ObserverA();
		
		cs.addObserver(obs1);
		cs.addObserver(obs2);
		cs.addObserver(obs3);
		
		cs.set(3000);
		
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		
		cs.set(600);
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
}
