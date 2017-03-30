package com.ibm.demo.test.demo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMapDemo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr="this is a cat and this is a mice and what is the food".split(" ");
		Map<String, Letter> map=new HashMap<String, Letter>();
		for(String key:arr){
			/*if(!map.containsKey(key)){
				map.put(key, new Letter(key));
			}
			Letter value=map.get(key);
			value.setCount(value.getCount()+1);*/
			Letter value=map.get(key);
			if(null==value){
				value=new Letter(key);
				map.put(key, value);
			}
			value.setCount(value.getCount()+1);
			
		}
		for(String key:map.keySet()){
			Letter value=map.get(key);
			System.out.println(key+"-->"+value.getCount()+"-->"+value.getName());
		}
		
		
	}

}
