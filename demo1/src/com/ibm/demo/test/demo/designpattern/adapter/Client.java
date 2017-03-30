package com.ibm.demo.test.demo.designpattern.adapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 客户端类
 * （相当于例子中的笔记本，只有usb接口）
 * @author liumy
 *
 */
public class Client {
	
	public void test1(Target t){
		t.handleReq();
	}
	
	public static void main(String[] args) {
		Client cl=new Client();
		
		Adaptee a =new Adaptee();
		
		Target t=new Adapter();
		cl.test1(t);
		
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(new FileInputStream("C:/aa/bb/cc/4.txt"),"gbk");
			char[] data=new char[1024];
			int flush=0;
			while(-1!=(flush=isr.read(data))){
				System.out.println(new String(data,0,flush));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
