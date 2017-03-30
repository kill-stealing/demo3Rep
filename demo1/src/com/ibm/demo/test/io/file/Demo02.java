package com.ibm.demo.test.io.file;

import java.io.File;
import java.io.IOException;

/*
 * 相对路径与绝对路径构造file对象
 */
public class Demo02 {
	public static void main(String[] args) {
		
		String parentPathString="C:/aa/bb/cc";
		String name="1.png";
		//相对路径
		File file=new File(parentPathString,name);
		File file1=new File(new File(parentPathString),name);
		System.out.println(file.getName());
		System.out.println(file1.getName());
		//绝对路径
		file=new File("C:/aa/bb/cc/1.png");
		System.out.println(file.getName());
		file=new File("com/ibm/demo/text.txt");
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.exists());
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
