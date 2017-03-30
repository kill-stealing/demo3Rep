package com.ibm.demo.test.io.file;

import java.io.File;
import java.io.IOException;

public class Demo03 {
	public static void main(String[] args) {
//		test2();
		try {
			test3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//3.创建文件 删除文件
	public static void test3() throws InterruptedException{
		File src=new File("C:/aa/bb/cc/200.jpg");
		if(!src.exists()){
			boolean flag=false;
			try {
				flag = src.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(flag);
		}
		
		boolean flag=src.delete();
		System.out.println(flag);
		
		Thread.sleep(1000);
		
		try {
			src=File.createTempFile("tes", ".temp",new File("C:/aa/bb/cc"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		src.deleteOnExit();
		
	}
	
	//2.判断信息 
	public static void test2(){
		File src=new File("C:/aa/bb/cc");
		System.out.println("文件是否存在"+src.exists());
		System.out.println("文件是否可写"+src.canWrite());
		//长度
		System.out.println(src.length());
	}
	
	//1.名称
	public static void test1(){
		File src=new File("C:/aa/bb/cc/1.png");
//		File src=new File("1.png");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());//返回上一级目录
		
	
	}
}
