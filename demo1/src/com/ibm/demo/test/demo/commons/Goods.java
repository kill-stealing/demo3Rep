package com.ibm.demo.test.demo.commons;

public class Goods {
	private String nameString;
	private double price;
	private boolean discount;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isDiscount() {
		return discount;
	}
	public void setDiscount(boolean discount) {
		this.discount = discount;
	}
	public Goods(String nameString, double price, boolean discount) {
		super();
		this.nameString = nameString;
		this.price = price;
		this.discount = discount;
	}
	public Goods(){
		
	}
	
	@Override
	public String toString() {
		return "商品："+this.nameString+"，价格："+this.price+",是否打折:"+(this.discount?"是":"否");
	}
}
