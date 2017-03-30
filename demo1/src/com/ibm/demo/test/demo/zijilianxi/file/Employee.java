package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.Serializable;


/**
 * 空接口只是标识
 * @author liumy
 *
 */
public class Employee implements Serializable{
	//不需要序列化
	private transient String name;
	private double salary;
	
	public Employee(){
		
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
