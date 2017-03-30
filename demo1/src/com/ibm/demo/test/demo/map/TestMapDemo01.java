package com.ibm.demo.test.demo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMapDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr="this is a cat and this is a mice and what is the food".split(" ");
		Map<String, Integer> map=new HashMap<String, Integer>();
		for(String key:arr){
			/*if(!map.containsKey(key)){
				map.put(key, 1);
			}else{
				map.put(key, map.get(key)+1);
			}*/
			
			Integer value=map.get(key);
			if(null==value){
				map.put(key, 1);
			}else{
				map.put(key, value+1);
			}
		}
		Set<String> keySet=map.keySet();
		Iterator<String> iterator=keySet.iterator();
		while(iterator.hasNext()){
			String keyString=iterator.next();
			Integer valueInteger=map.get(keyString);
			System.out.println(keyString+"-->"+valueInteger);
		}
		
	}

}
