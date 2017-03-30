package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Demo01 {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://9.51.101.218:3306/nase";
	    String username = "efriday";
	    String password = "efriday123";
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        long start=System.currentTimeMillis();
	        Connection conn = (Connection) DriverManager.getConnection(url, username, password);
	        long end=System.currentTimeMillis();
	        System.out.println("建立链接 耗时："+(end-start));
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
