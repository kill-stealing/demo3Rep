package com.ibm.demo.test.demo.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试反射和反序列化破解单例模式
 * @author liumy
 *
 */
public class ClientDemo02 {

	public static void main(String[] args)throws Exception {
		SingletonDemo0201 s1=SingletonDemo0201.getInstance();
		SingletonDemo0201 s2=SingletonDemo0201.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		//通过反射的方式直接调用私有构造器
//		Class<SingletonDemo0201> clz=(Class<SingletonDemo0201>)Class.forName("com.ibm.demo.test.demo.designpattern.singleton.SingletonDemo0201");
//		Constructor<SingletonDemo0201> c=clz.getDeclaredConstructor(null);
//		c.setAccessible(true);
//		SingletonDemo0201 s3=c.newInstance();
//		SingletonDemo0201 s4=c.newInstance();
//		
//		System.out.println(s3);
//		System.out.println(s4);
		
		//通过反序列化的方式构造多个对象
		FileOutputStream fos=new FileOutputStream("C:/myJava/a.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.flush();
		oos.close();
		fos.close();
		FileInputStream fis=new FileInputStream("C:/myJava/a.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		SingletonDemo0201 s11=(SingletonDemo0201)ois.readObject();
		ois.close();
		fis.close();
		System.out.println(s11);
		System.out.println(s1);
	}

}
