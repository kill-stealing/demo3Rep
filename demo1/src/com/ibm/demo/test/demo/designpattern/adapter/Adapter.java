package com.ibm.demo.test.demo.designpattern.adapter;
/**
 * 适配器(类适配器方式)
 * (usb和ps2 的转接器)
 * @author liumy
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleReq() {
		super.request();
	}

}
