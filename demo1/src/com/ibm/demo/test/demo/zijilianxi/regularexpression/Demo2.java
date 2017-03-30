package com.ibm.demo.test.demo.zijilianxi.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Demo2 {

	public static void main(String[] args) {
		//在这个字符串中：asd2321321中，是否符合指定的表达式：\w+
		
		//表达式对象 
		Pattern p=Pattern.compile("([a-z]+)([0-9]+)");
		
		//创建Matcher对象
		Matcher m=p.matcher("aa12321**dadfas123**dsaf2131");
//		boolean yesOrNo=m.matches();//尝试将整个字符序列与该模式匹配
		
//		boolean yesOrNo1=m.find();	//该方法扫描输入的序列，查找与该模式匹配的下一个子序列
//		boolean yesOrNo2=m.find();
//		boolean yesOrNo3=m.find();
//		boolean yesOrNo4=m.find();
////		System.out.println(yesOrNo);
//		System.out.println(yesOrNo1);
//		System.out.println(yesOrNo2);
//		System.out.println(yesOrNo3);
//		System.out.println(yesOrNo4);
		
//		System.out.println(m.find());
//		System.out.println(m.group());
//		System.out.println(m.find());
//		System.out.println(m.group());
		
		while(m.find()){
			System.out.println(m.group());//group()和group(0)匹配整个表达式的子字符串
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			System.out.println("------------------");
		}
	}

}
