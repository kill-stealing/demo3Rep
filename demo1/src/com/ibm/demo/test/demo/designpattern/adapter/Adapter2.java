package com.ibm.demo.test.demo.designpattern.adapter;
/**
 * 适配器(组合方式)
 * (usb和ps2 的转接器)
 * @author liumy
 *
 */
public class Adapter2 implements Target{
	private Adaptee a;
	
	public Adapter2(Adaptee a) {
		this.a=a;
	}
	
	@Override
	public void handleReq() {
		a.request();
	}

}
