package com.ibm.demo.test.demo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMapDemo03 {
	
	public static List<Student> exam(){
		List<Student> list=new ArrayList<Student>();
		list.add(new Student("a1", "a", 85));
		list.add(new Student("a2", "a", 87));
		list.add(new Student("a3", "a", 89));
		list.add(new Student("a4", "a", 82));
		list.add(new Student("a5", "a", 81));
		
		list.add(new Student("b1", "b", 85));
		list.add(new Student("b2", "b", 87));
		return list;
	}
	
	public static Map<String, ClassRoom> count(List<Student> list){
		Map<String, ClassRoom> map=new HashMap<String, ClassRoom>();
		for(Student stu:list){
			String no=stu.getNo();//班级
			double score=stu.getScore();
			ClassRoom room=map.get(no);
			if(null==room){
				room=new ClassRoom(no);
				map.put(no, room);
			}
			room.getStuList().add(stu);
			room.setTotal(room.getTotal()+score);
		}
		return map;
	}
	
	public static void view(Map<String, ClassRoom> map){
		Set<String> keysSet=map.keySet();
		Iterator<String> iterator=keysSet.iterator();
		while(iterator.hasNext()){
			String no=iterator.next();
			ClassRoom room=map.get(no);
			double total=room.getTotal();
			double avg=total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+avg);
		}
	}
	
	public static void main(String[] args) {
		List<Student> list=exam();
		Map<String,ClassRoom> map=count(list);
		view(map);
		
	}
}
