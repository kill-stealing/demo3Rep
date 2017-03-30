package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行sql语句以及sql注入问题
 * @author liumy
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://9.51.101.218:3306/nase";
	    String username = "efriday";
	    String password = "efriday123";
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        Connection conn = (Connection) DriverManager.getConnection(url, username, password);
	        Statement stmt=conn.createStatement();
//	        String sql="insert into list (id) values(1)";
//	        stmt.execute(sql);
	        
	        //测试sql注入
	        String name="'aaa' or 1=1";
	        String sql="delete from list where name="+name;
	        System.out.println(sql);
	        stmt.execute(sql);
	        
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
