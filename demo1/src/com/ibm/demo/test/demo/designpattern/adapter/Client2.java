package com.ibm.demo.test.demo.designpattern.adapter;
/**
 * 客户端类
 * （相当于例子中的笔记本，只有usb接口）
 * @author liumy
 *
 */
public class Client2 {
	
	public void test1(Target t){
		t.handleReq();
	}
	
	public static void main(String[] args) {
		Client2 cl=new Client2();
		
		Adaptee a =new Adaptee();
		
		Target t=new Adapter2(a);
		cl.test1(t);
	}
}
