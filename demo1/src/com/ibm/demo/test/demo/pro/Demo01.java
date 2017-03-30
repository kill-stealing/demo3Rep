package com.ibm.demo.test.demo.pro;

import java.util.Properties;


/*
 * properties 资源配置文件读写
 */
public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pro=new Properties();
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("password", "tiger");
		
		System.out.println(pro.getProperty("user", "test"));
	}

}
