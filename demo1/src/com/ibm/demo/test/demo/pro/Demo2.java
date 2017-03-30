package com.ibm.demo.test.demo.pro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * 使用properties输出到文件中
 * 资源配置文件
 * 1
	 * 1.store(OutputStream out, String comments) 
	 * 2.store(Writer writer, String comments)
   2
	 * 3.storeToXML(OutputStream os, String comment) 
	 * 4.storeToXML(OutputStream os, String comment, String encoding) 
 */
public class Demo2 {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		//创建对象
		Properties pro=new Properties();
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("password", "tiger");
		
		//存储到c:/others 绝对路径 盘符：
		//pro.store(new FileOutputStream(new File("c:/db.properties")), "db配置");
//		pro.storeToXML(new FileOutputStream(new File("c:/db.xml")), "db配置xml");
		pro.store(new FileOutputStream(
				new File("src/com/ibm/demo/test/demo/pro/db.properties")), "db配置");
		
	}
}
