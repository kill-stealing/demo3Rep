package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestPrintStream {

	public static void main(String[] args) {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.print(false);
		File src = new File("c:/aa/bb/cc/7.txt");
		try {
			ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(
					src)));
			ps.println("io is so easy...中国");
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
