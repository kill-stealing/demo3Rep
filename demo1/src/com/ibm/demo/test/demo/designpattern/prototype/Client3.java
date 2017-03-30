package com.ibm.demo.test.demo.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 测试原型模式(深复制，使用序列化和反序列化实现深复制)
 * 
 * @author liumy
 *
 */
public class Client3 {
	public static void main(String[] args) throws Exception {
		Date date = new Date(12312312312L);
		Sheep s1 = new Sheep("少理", date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
//		Sheep s2 = (Sheep) s1.clone();
		
		//使用序列化和反序列化实现深复制
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(s1);
		byte[] bytes=bos.toByteArray();
		ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
		ObjectInputStream ois=new ObjectInputStream(bis);
		Sheep s2=(Sheep) ois.readObject();
		
		date.setTime(1231235436456L);
		System.out.println(s1.getBirthday());

		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}
}
