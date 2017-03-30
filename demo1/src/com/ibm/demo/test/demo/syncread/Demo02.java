package com.ibm.demo.test.demo.syncread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 只读设置
 */
public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("test", "test");
		map.put("bjsxt", "bjsxt");
		
		//只读控制
		Map<String, String> map1=Collections.unmodifiableMap(map);
//		map1.put("a", "a");
		System.out.println(map1.size());
		
		//一个元素的容器测试
		List<String> list1=Collections.singletonList(new String());
//		list1.add("a");
		
	}
	
	

}
