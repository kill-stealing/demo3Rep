package com.ibm.demo.test.demo.designpattern.mediator;

import java.util.HashMap;

public class President implements Mediator{
	
	private HashMap<String , Department> map=new HashMap<String, Department>();

	@Override
	public void register(String name, Department d) {
		map.put(name, d);
	}

	@Override
	public void command(String dName) {
		map.get(dName).selfAction();
	}

}
