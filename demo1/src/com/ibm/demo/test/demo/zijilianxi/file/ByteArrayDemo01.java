package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class ByteArrayDemo01 {

	public static void main(String[] args) {
		read();
	}
	
	
	public static void read(){
		String msg="操作与文件输入流一致";
		InputStream biS=new BufferedInputStream(new ByteArrayInputStream(msg.getBytes()));
		byte[] flush=new byte[1024];
		int len=0;
		try {
			while(-1!=(len=biS.read(flush))){
				System.out.println(new String(flush,0,len));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出流 操作与文件输出流 有些不同 ，有新增方法 不能使用多态
	 */
	public static void write(){
		String msg="操作与文件输入流一致";
		byte[] msgB=msg.getBytes();
		byte[] dest;
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		try {
			os.write(msgB);
			os.flush();
			dest=os.toByteArray();
			os.close();
			System.out.println(new String(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
