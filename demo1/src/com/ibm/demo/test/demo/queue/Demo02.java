package com.ibm.demo.test.demo.queue;

public class Demo02 {
	public static void main(String[] args) {
		MyStack<String> backHistoryMyStack=new MyStack<String>(3);
		backHistoryMyStack.push("www.baidu.com");
		backHistoryMyStack.push("www.google.com");
		backHistoryMyStack.push("www.sina.com");
		backHistoryMyStack.push("www.bjsxt.com");
		
		System.out.println("大小："+backHistoryMyStack.size());
		
		
		//遍历
		String itemString=null;
		while (null!=(itemString=backHistoryMyStack.pop())) {
			System.out.println(itemString);
		}
	}
}
