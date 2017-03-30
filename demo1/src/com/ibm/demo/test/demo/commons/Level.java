package com.ibm.demo.test.demo.commons;

public class Level {
	private String name;
	private String level;
	
	public Level(){
		
	}
	public Level(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "码农："+this.name+",水平："+this.level;
	}
}
