package com.ibm.demo.test.demo.designpattern.chainOfResp;

public class Client {
	public static void main(String[] args) {
		Leader l1=new Director("张三");
		Leader l2=new Manager("李四");
		Leader l3=new GeneralManager("王五");
		Leader l4=new ViceGeneralManager("赵六");
		
		//组织责任链对象的关系
		l1.setNextLeader(l2);
		l2.setNextLeader(l4);
		l4.setNextLeader(l3);
		
		//开始请假操作
		LeaveRequest req1=new LeaveRequest("TOM", 20, "回英国老家探亲！");
		l1.handleRequest(req1);
	}
}
