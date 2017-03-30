package com.ibm.demo.test.demo.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/*
 * 读取properties文件
 * load(InputStream inStream)
 */
public class Demo3 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro=new Properties();
		//绝对路径
		pro.load(new FileReader(new File("c:/db.properties")));
		//读取相对路径
		//
		System.out.println(pro.getProperty("user","test"));
	}
}
