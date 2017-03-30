package com.ibm.demo.test.demo.annotation.javabean;

public class User {
	private String uName;
	private int id;
	private int age;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String uName, int id, int age) {
		super();
		this.uName = uName;
		this.id = id;
		this.age = age;
	}
	
	public User() {
		
	}
}
