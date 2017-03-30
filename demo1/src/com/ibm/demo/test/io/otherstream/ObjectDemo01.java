package com.ibm.demo.test.io.otherstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		seri("c:/aa/bb/cc/seriWrite.txt");
		read("c:/aa/bb/cc/seriWrite.txt");
	}

	// 反序列化
	public static void read(String srcPath) {

		try {
			ObjectInputStream input = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(new File(srcPath))));
			
			Object obj=input.readObject();
			if(obj instanceof Employee){
				Employee employee=(Employee)obj;
				System.out.println(employee.getName()+" "+employee.getSalary());
			}
			
			int[] arr=(int[])input.readObject();
			System.out.println(Arrays.toString(arr));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 序列化
	public static void seri(String destPath) {
		Employee employee = new Employee("北京尚学堂", 10000L);
		int[] arr={1,2,3,4,5};
		// 创建源
		File dest = new File(destPath);
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(dest)));
			out.writeObject(employee);
			out.writeObject(arr);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
