package com.ibm.demo.test.io.otherstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.apache.tomcat.jni.File;

/**
 * 三个常量 1.system.in 2.system.out system.err
 * 
 * @author liumy
 *
 */
public class SystemDemo01 {

	public static void main(String[] args) {
		// test2();
		// 控制台-》文件
		try {
			// 重定向到文件
			System.setOut(new PrintStream(new BufferedOutputStream(
					new FileOutputStream("c:/aa/bb/cc/dest.txt")), true));
			System.out.println("牛逼");
			// 重定向回控制台
			System.setOut(new PrintStream(new BufferedOutputStream(
					new FileOutputStream(FileDescriptor.out)),true));
			System.out.println("牛逼牛逼");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test2() {
		InputStream iStream = System.in;
		try {
			iStream = new BufferedInputStream(new FileInputStream(
					new java.io.File("c:/aa/bb/cc/dest.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner src = new Scanner(iStream);
		System.out.println(src.nextLine());

	}

	public static void test1() {
		System.out.println("test");
		System.err.println("err");
	}

}
