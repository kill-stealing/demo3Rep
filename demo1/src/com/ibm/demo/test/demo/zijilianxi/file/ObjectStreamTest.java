package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import com.ibm.demo.test.io.otherstream.Employee;

public class ObjectStreamTest {

	public static void main(String[] args) {
		read("C:/aa/bb/cc/6.txt");
//		write();
	}

	public static void read(String path) {
		File file = new File(path);
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(file)));
			Employee e=(Employee)ois.readObject();
			int[] a=(int[])ois.readObject();
			System.out.println(Arrays.toString(a));
			System.out.println(e.getName()+"-->"+e.getSalary());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=ois){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void write() {
		Employee e = new Employee("abc", 100.1);
		int[] array = { 1, 2, 3, 4, 5 };
		File f = new File("C:/aa/bb/cc/6.txt");
		ObjectOutputStream ois = null;
		try {
			ois = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(f)));
			ois.writeObject(e);
			ois.writeObject(array);
			ois.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (null != ois) {
				try {
					ois.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
