package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试批处理的基本用法
 * @author liumy
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://9.51.101.218:3306/nase";
	    String username = "efriday";
	    String password = "efriday123";
	    Connection conn =null;
	    Statement st=null;
	    ResultSet rs=null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	        String sql="select * from list where id>?";
	        conn.setAutoCommit(false);
	        long start=System.currentTimeMillis();
	        st=conn.createStatement();
	        for(int i=0;i<20;i++){
	        	st.addBatch("insert into list values("+i+",'name"+i+"')");
	        	System.out.println(i);
	        }
	        st.executeBatch();
	        conn.commit();
	        long end=System.currentTimeMillis();
	        System.out.println("插入20000条数据耗时（毫秒）："+(end-start));
	        
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
	    	if(st!=null){
	    		try {
	    			st.close();
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
