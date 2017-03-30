package com.ibm.demo.test.demo.zijilianxi.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试替换操作
 * @author liumy
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		//在这个字符串中：asd2321321中，是否符合指定的表达式：\w+
		//表达式对象 
		Pattern p=Pattern.compile("[0-9]");
		//创建Matcher对象
		Matcher m=p.matcher("aa12321**dadfas123**dsaf2131");
		//替换
//		String newStr=m.replaceAll("#");
//		System.out.println(newStr);
		//分割
		
		
	}

}
