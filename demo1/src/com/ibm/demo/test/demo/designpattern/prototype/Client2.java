package com.ibm.demo.test.demo.designpattern.prototype;

import java.util.Date;

/**
 * 测试原型模式(深克隆)
 * @author liumy
 *
 */
public class Client2 {
	public static void main(String[] args) {
		Date date=new Date(12312312312L);
		Sheep2 s1=new Sheep2("少理",date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		try {
			Sheep2 s2=(Sheep2) s1.clone();
			date.setTime(1231235436456L);
			System.out.println(s1.getBirthday());
			
			System.out.println(s2);
			System.out.println(s2.getName());
			System.out.println(s2.getBirthday());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
