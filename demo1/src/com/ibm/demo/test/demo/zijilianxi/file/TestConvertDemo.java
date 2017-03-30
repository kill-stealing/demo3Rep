package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.UnsupportedEncodingException;

public class TestConvertDemo {

	public static void main(String[] args) {
		String str="中国人";
		byte[] data=str.getBytes();
		System.out.println(new String(data,0,3));
	}
	
	//解码与编码字符集必须相同，否则乱码
	public static void test1(){
		//解码
		String str="中国";
		byte[] aa=str.getBytes();
		System.out.println(new String(aa));
		try {
			aa=str.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(aa));
	
	}

}
