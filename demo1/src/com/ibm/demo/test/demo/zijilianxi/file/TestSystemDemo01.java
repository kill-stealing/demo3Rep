package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestSystemDemo01 {

	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}
	
	public static void test3(){
		//重定向
		try {
			System.setOut(new PrintStream(
					new BufferedOutputStream
					(new FileOutputStream(new File("c:/aa/bb/cc/dest.txt"))),true));
			
			System.out.println("a");
			
			System.setOut(new PrintStream(new BufferedOutputStream(
					new FileOutputStream(FileDescriptor.out)),true));
			
			System.out.println("牛逼牛逼");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test1() {
		System.out.println("test");
		System.err.println("err");
	}
	
	public static void test2(){
		InputStream is = System.in;
		try {
			is = new BufferedInputStream(new FileInputStream(
					new File(
					"c:/aa/bb/cc/dest.txt")));
			Scanner sc = new Scanner(is);
			System.out.println(sc.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
