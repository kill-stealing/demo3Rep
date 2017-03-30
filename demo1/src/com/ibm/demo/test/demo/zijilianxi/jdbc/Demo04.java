package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试prepareStatement的基本用法
 * @author liumy
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://9.51.101.218:3306/nase";
	    String username = "efriday";
	    String password = "efriday123";
	    Connection conn =null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	        String sql="select * from list where id>?";
	        ps=conn.prepareStatement(sql);
	        ps.setObject(1, 0);
	        
	        rs=ps.executeQuery();
	        while(rs.next()){
	        	System.out.println(rs.getInt(1));
	        	System.out.println(rs.getString(2));
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{ 
	    	//遵循：resultSet-->statement-->connection这样的关闭顺序 一定要将三个trycatch快分开写
	    	if(rs!=null){
	    		try {
	    			rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(ps!=null){
	    		try {
	    			ps.close();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	}
	    	if(conn!=null){
	    		try {
	    			conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }
	}
}
