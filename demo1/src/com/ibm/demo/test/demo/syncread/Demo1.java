package com.ibm.demo.test.demo.syncread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		//list可以同步
		List<String> list1=Collections.synchronizedList(list);
	}
}
