package com.ibm.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestFileExit {

	public static void main(String[] args) {
		
		Map<String, String> map1=new HashMap<String, String>();
		map1.put("a6", "value6");
		map1.put("a7", "value7");
		map1.put("a8", "value8");
		map1.put("a9", "value9");
		map1.put("a10", "value10");
		Set<String> set =map1.keySet();
		Iterator<String> iterator=set.iterator();
		List<String> list1=new ArrayList<String>();
		while(iterator.hasNext()){
			list1.add(iterator.next());
		}
		
		System.out.println(list1);
		
		List<String> list2=new ArrayList<String>();
		for(String a:list1){
			list2.add(map1.get(a));
		}
		
		System.out.println(list2);
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("a1", "value1");
		map.put("a2", "value2");
		map.put("a3", "value3");
		map.put("a4", "value4");
		map.put("a5", "value5");
		
		System.out.println(map);
		
		List<Map<String, String>> list=new ArrayList<Map<String, String>>();
		list.add(map1);
		list.add(map);
		System.out.println(list);
		
		// TODO Auto-generated method stub
//		File file=new File("C:\\test111");
//		if(!file.exists()){
//			System.out.println("test");
//			file.mkdirs();
//		}
	}

}
