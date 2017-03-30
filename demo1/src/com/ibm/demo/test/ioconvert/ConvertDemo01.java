package com.ibm.demo.test.ioconvert;

import java.io.UnsupportedEncodingException;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ConvertDemo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string="中国"; //gbk
		//编码 char 转byte
		byte[] data=string.getBytes();
		//字节数缺少
		System.out.println(new String(data,0,3));
	}
	
	/*
	 * 编码与解码字符集必须相同，否则出现乱码
	 */
	public static void test1() throws UnsupportedEncodingException{
		//解码 byte 转char
		String string="中国"; //gbk
		//编码 char 转byte
		byte[] data=string.getBytes();
		System.out.println(new String(data));
		//不统一出现乱码
		data=string.getBytes("GBK");//设定编码的字符集
		
		//编码
		byte[] data2;
			data2 = "中国".getBytes("utf-8");
		//解码
		string=new String(data2,"utf-8");
		System.out.println(new String(data2));
	
	}
}
