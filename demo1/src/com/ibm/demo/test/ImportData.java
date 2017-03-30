package com.ibm.demo.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ImportData {
	
	public ImportData(){
		
	}
	
	public static void main(String[] args) {
		getAll1();
	}
	
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://9.51.101.218:3306/nase";
	    String username = "efriday";
	    String password = "efriday123";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	private static Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from nase_posts";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	private static Integer getAll1() {
	    Connection conn = getConn();
	    String sql = "INSERT INTO nase_posts (post_date,post_author,post_content,"
	    		+ "post_title,post_status,post_type,post_excerpt,to_ping,pinged,"
					+ "post_content_filtered) VALUES ('2017-02-13 14:44:23',"
	    		+ "4,'insert content text','insert content text','publish','nasemobile',"
	    		+ "'post_excerpt','to_ping','pinged','post_content_filtered')";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        int rs = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
