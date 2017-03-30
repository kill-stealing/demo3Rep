package com.ibm.demo.test.demo.zijilianxi.jdbc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试blob大对象的使用
 * 
 * @author liumy
 *
 */
public class Demo09 {
	/**
	 * 将字符串
	 * 
	 * @param str2Date
	 * @return
	 */
	public static long str2Date(String str2Date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return df.parse(str2Date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://9.51.101.218:3306/nase";
		String username = "efriday";
		String password = "efriday123";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // classLoader,加载对应驱动
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public static void main(String[] args) {
		query(getConn());
//		doInsert(getConn());
//		doInsert1(getConn());
	}
	
	public static void query(Connection conn) {
		PreparedStatement ps2 = null;
		String sql = "select * from list where id=1";
		ResultSet rs = null;
		BufferedOutputStream bos=null;
		InputStream is=null;
		try {
			ps2 = conn.prepareStatement(sql);
			rs = ps2.executeQuery();
			while (rs.next()) {
//				Clob c = rs.getClob("myInfo");
//				Reader r = c.getCharacterStream();
//				int temp = 0;
//				while ((temp = r.read()) != -1) {
//					System.out.print((char) temp);
//				}
				Blob b = rs.getBlob("headImg");
				is=b.getBinaryStream();
				bos=new BufferedOutputStream(new FileOutputStream("C:/a.jpg"));
				int len=0;
				while(-1!=(len=is.read())){
					bos.write(len);
				}
				bos.flush();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(is,bos);
			// 遵循：resultSet-->statement-->connection这样的关闭顺序 一定要将三个trycatch快分开写
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps2 != null) {
				try {
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void doInsert(Connection conn) {
		PreparedStatement ps2 = null;
		String sql = "insert into list (headImg) values(?)";
		ResultSet rs = null;
		try {
			ps2 = conn.prepareStatement(sql);
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:/Users/IBM_ADMIN/Desktop/img folder/1b84472309f79052fe8be87c0ef3d7ca7acbd5f8.jpg"));
			ps2.setBlob(1, bis);
			ps2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 遵循：resultSet-->statement-->connection这样的关闭顺序 一定要将三个trycatch快分开写
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps2 != null) {
				try {
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void doInsert1(Connection conn) {
		PreparedStatement ps2 = null;
		String sql = "insert into list (id,myInfo) values(?,?)";
		ResultSet rs = null;
		try {
			ps2 = conn.prepareStatement(sql);
			ps2.setInt(1, 2);
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:/aa/bb/cc/computer config.txt"));
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			int len=0;
			byte[] flush=new byte[1024];
			while(-1!=(len=bis.read(flush))){
				bos.write(flush,0,len);
			}
			ps2.setBytes(2, bos.toByteArray());
			ps2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 遵循：resultSet-->statement-->connection这样的关闭顺序 一定要将三个trycatch快分开写
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps2 != null) {
				try {
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void closeAll(Closeable... io) {
		for (Closeable closeable : io) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
