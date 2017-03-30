package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试事务的基本用法
 * @author liumy
 *
 */
public class Demo07 {
	/**
	 * 将字符串
	 * @param str2Date
	 * @return
	 */
	public static long str2Date(String str2Date){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return df.parse(str2Date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://9.51.101.218:3306/nase";
	    String username = "efriday";
	    String password = "efriday123";
	    Connection conn =null;
	    PreparedStatement ps2=null;
	    ResultSet rs=null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	        String sql="select * from list where born_date >? and born_date <?";
	        ps2=conn.prepareStatement(sql);
	        java.sql.Date start=new java.sql.Date(str2Date("2017-3-1 00:00:00")); 
	        java.sql.Date end=new java.sql.Date(str2Date("2017-12-31 00:00:00")); 
	        ps2.setObject(1, start);
	        ps2.setObject(2, end);
	        rs=ps2.executeQuery();
	        while(rs.next()){
	        	System.out.println(rs.getInt("id")+"--"+rs.getString("name")+"--"+rs.getDate("born_date"));
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	    	if(ps2!=null){
	    		try {
	    			ps2.close();
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
