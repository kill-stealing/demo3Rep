package com.ibm.demo.test.io.otherstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

/**
 * 数据类型（基本+String ）处理流 DataInputStream DataOutputStream
 * 
 * java.io.EOFException 没有读取到相关内容
 * @author liumy
 *
 */
public class DataDemo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			write("c:/aa/bb/cc/write.txt");
//			read("c:/aa/bb/cc/write.txt");
			read(write());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 数据+类型输出到字节数组
	 * 
	 * @throws IOException
	 */
	public static byte[] write() throws IOException {
		double poing = 2.5;
		long num = 100L;
		String string = "数据类型";
		byte[] dest;
		
		ByteArrayOutputStream bosArrayOutputStream=new ByteArrayOutputStream();
		
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bosArrayOutputStream));
		// 操作
		dos.writeDouble(poing);
		dos.writeLong(num);
		dos.writeUTF(string);
		dos.flush();
		
		dest=bosArrayOutputStream.toByteArray();
		dos.close();
		return dest;
	}

	/**
	 * 从文件读取数据+类型
	 * @throws IOException 
	 * 
	 */
	public static void read(String destPath) throws IOException {
		File src = new File(destPath);
		DataInputStream inputStream = new DataInputStream(
				new BufferedInputStream(new FileInputStream(src)));
		double num1=inputStream.readDouble();
		long num2=inputStream.readLong();
		String str=inputStream.readUTF();
		System.out.println(num1);
		System.out.println(num2);
//		System.out.println(str);
	}
	
	/**
	 * 从字节数组读取数据+类型 
	 * @throws IOException 
	 * 
	 */
	public static void read(byte[] src) throws IOException {
		ByteArrayInputStream in=new ByteArrayInputStream(src);
		DataInputStream inputStream = new DataInputStream(
				new BufferedInputStream(in));
		double num1=inputStream.readDouble();
		long num2=inputStream.readLong();
		String str=inputStream.readUTF();
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(str);
	}

}
