package com.ibm.demo.test.demo.zijilianxi.file;

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

public class DataInputStreamTest {

	public static void main(String[] args) throws IOException {
//			write("c:/aa/bb/cc/write.txt");
//			read("c:/aa/bb/cc/write.txt");
		readFromArray(writeIntoByteArray());
		
	}
	
	/**
	 * 从字节数组读取数据+类型
	 * @throws IOException 
	 * 
	 */
	public static void readFromArray(byte[] a) throws IOException {
		DataInputStream inputStream = new DataInputStream(
				new BufferedInputStream(new ByteArrayInputStream(a)));
		double num1=inputStream.readDouble();
		long num2=inputStream.readLong();
		String str=inputStream.readUTF();
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(str);
	}
	
	/**
	 * 数据+类型输出到字节数组
	 * @return
	 */
	public static byte[] writeIntoByteArray() {
		double a = 1.2;
		long b = 100L;
		String str = "数据类型";
		byte[] data=null;
		// DataOutputStream
		ByteArrayOutputStream bis=new ByteArrayOutputStream();
		File f = new File("C:/aa/bb/cc/5.txt");
		DataOutputStream dps=null;
		try {
			dps = new DataOutputStream(new BufferedOutputStream(bis));
			dps.writeDouble(a);
			dps.writeLong(b);
			dps.writeUTF(str);
			dps.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(null!=dps){
				try {
					data=bis.toByteArray();
					dps.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	/**
	 * 数据+类型输出到文件
	 * 
	 * @throws IOException
	 */
	public static void write(String destPath) throws IOException {
		double poing = 2.5;
		long num = 100L;
		String string = "数据类型";

		// 创建源
		File dest = new File(destPath);
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(dest)));
		// 操作
		dos.writeDouble(poing);
		dos.writeLong(num);
		dos.writeUTF(string);
		dos.flush();
		dos.close();
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

}
