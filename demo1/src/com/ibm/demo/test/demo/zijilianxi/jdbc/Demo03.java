package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试prepareStatement的基本用法
 * @author liumy
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://9.51.101.218:3306/nase";
	    String username = "efriday";
	    String password = "efriday123";
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        Connection conn = (Connection) DriverManager.getConnection(url, username, password);
	        String sql="insert into list (id,name) values(?,?)";
	        PreparedStatement ps=conn.prepareStatement(sql);
//	        ps.setInt(1, 2);	//参数索引是从1开始计算，而不是0
//	        ps.setString(2, "aaab");
	        
	        ps.setObject(1, 5);
	        ps.setObject(2, "ahjkgf");
	        
	        int count=ps.executeUpdate();
	        System.out.println(count);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
