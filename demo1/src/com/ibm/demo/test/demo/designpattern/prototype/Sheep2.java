package com.ibm.demo.test.demo.designpattern.prototype;

import java.util.Date;

public class Sheep2 implements Cloneable{
	private String name;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();//直接调用object对象的clone方法
		Sheep2 s=(Sheep2) obj;
		s.birthday=(Date) s.birthday.clone();
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Sheep2(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	
	public Sheep2() {
	}
}
