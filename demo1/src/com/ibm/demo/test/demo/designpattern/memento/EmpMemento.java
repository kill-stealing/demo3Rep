package com.ibm.demo.test.demo.designpattern.memento;
/**
 * 备忘录类
 * @author liumy
 *
 */
public class EmpMemento {
	private String ename;
	private int age;
	private double salary;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public EmpMemento(String ename, int age, double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
	}
	
	public EmpMemento(Emp e) {
		this.ename=e.getEname();
		this.age=e.getAge();
		this.salary=e.getSalary();
	}
}
