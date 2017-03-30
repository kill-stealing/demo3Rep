package com.ibm.demo.test.demo.designpattern.memento;

public class Client {
	public static void main(String[] args) {
		CareTaker ct=new CareTaker();
		Emp emp=new Emp("张三",18,900);
		
		System.out.println("第一次打印对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());
		ct.setMemento(emp.memento());	//备忘一次
		
		emp.setAge(38);
		emp.setEname("李四");
		emp.setSalary(10000);
		System.out.println("第二次打印对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());
		
		emp.recovery(ct.getMemento());	//恢复
		System.out.println("第三次打印对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());
		
	}
}
