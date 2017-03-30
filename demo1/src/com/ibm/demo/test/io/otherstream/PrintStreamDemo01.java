package com.ibm.demo.test.io.otherstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream 打印流 --》处理流
 * 
 * @author liumy
 *
 */
public class PrintStreamDemo01 {

	public static void main(String[] args) {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.println(false);

		// 输出到文件
		File src = new File("c:/aa/bb/cc/seriWrite.txt");
		try {
			ps = new PrintStream(
					new BufferedOutputStream(new FileOutputStream(src)));
			ps.println("io is so 大哥 ...");
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
