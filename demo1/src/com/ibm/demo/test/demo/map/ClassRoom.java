package com.ibm.demo.test.demo.map;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	private String no;
	private List<Student> stuList;
	private double total;//总分
	public ClassRoom(){
		stuList=new ArrayList<Student>();
	}
	public ClassRoom(String no){
		this();
		this.no=no;
	}
	public ClassRoom(String no, List<Student> stuList, double total) {
		super();
		this.no = no;
		this.stuList = stuList;
		this.total = total;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getStuList() {
		return stuList;
	}
	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
