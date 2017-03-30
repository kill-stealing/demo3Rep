package com.ibm.demo.test.io.otherstream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节数组 节点流
 * 数组的长度有限 数据量不会很大
 * @author liumy
 *
 */
public class ByteArrayDemo01 {	
	
	public static void main(String[] args){
		try {
			handle();
			read(write());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出流 操作与文件输入流有些不同，有新增方法，不能使用多态
	 * @throws IOException
	 */
	public static byte[] write() throws IOException{
		//目的地
		byte[] dest;
		//选择流
		ByteArrayOutputStream boStream=new ByteArrayOutputStream();
		//写出
		//数据源
		String msg="操作与文件输入流操作一致";
		byte[] info=msg.getBytes();
		boStream.write(info,0,info.length);
		//获取数据
		dest=boStream.toByteArray();
		//释放资源
		boStream.close();
		
		return dest;
	}
	
	
	/*
	 * 输入流操作 与文件输入流操作一致
	 * 读取字节数组
	 */
	public static void read(byte[] src) throws IOException{
		/**
		 * 
		 */
		InputStream is =new BufferedInputStream(new ByteArrayInputStream(src));
		//操作 
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			System.out.println(new String(flush,0,len));
		}
		is.close();
	}
	
	/***
	 * 文件  程序 字节数组
	 * 字节数组 程序 文件
	 */
	public static void handle(){
		File file=new File("c:/aa/bb/cc/1.txt");
		try {
			InputStream is=new FileInputStream(file);
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
			byte[] flush=new byte[1024];
			int len=0;
 			while(-1!=(len=is.read(flush))){
 				outputStream.write(flush, 0, len);
			}
 			outputStream.flush();
 			
 			byte[] dest=outputStream.toByteArray();
 			
 			OutputStream outputStream2=new FileOutputStream(new File("c:/aa/bb/cc/dest0723.txt"));
 			
 			outputStream2.write(dest,0,dest.length);
 			outputStream2.flush();
 			outputStream2.close();
 			
 			outputStream.close();
 			is.close();
 			
 			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
