package com.ibm.demo.test.demo.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类
 * 管理备忘录对象
 * @author liumy
 *
 */
public class CareTaker {
	
	private EmpMemento memento;
	
//	private List<EmpMemento> list=new ArrayList<EmpMemento>();

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}
	
	
}
