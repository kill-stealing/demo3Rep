package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

/**
 * 测试事务的基本用法
 * @author liumy
 *
 */
public class Demo06 {
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
	        String sql="insert into list values(?,?,?,?,?)";
	        conn.setAutoCommit(false);
	        for(int i=0;i<20;i++){
	        	int rand=100000+new Random().nextInt(1000000);
	        	java.sql.Date date=new java.sql.Date(System.currentTimeMillis()-rand);
		        Timestamp timestamp=new Timestamp(System.currentTimeMillis()-rand);
		        Time time=new Time(System.currentTimeMillis()+rand);
		        ps2=conn.prepareStatement(sql);
		        ps2.setObject(1, i);
		        ps2.setObject(2, "name"+i);
		        ps2.setObject(3, date);
		        ps2.setObject(4, timestamp);
		        ps2.setObject(5, time);
		        ps2.execute();
	        }
	        conn.commit();
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
