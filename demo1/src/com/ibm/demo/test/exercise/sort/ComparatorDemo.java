package com.ibm.demo.test.exercise.sort;

import java.util.Comparator;

public class ComparatorDemo implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return -(o1.length()-o2.length());
	}
	
}
