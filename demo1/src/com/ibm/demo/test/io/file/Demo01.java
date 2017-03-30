package com.ibm.demo.test.io.file;
/*
 * 文件 
 * 	路径分隔符 pathSeparator  ;
 *  文件分隔符 separator \ window  / linux  
 *  推荐使用  path="E:/xp/test/2.jpg";
 *  
 * 	
 */
import java.io.File;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.separator+"  "+File.pathSeparator);
		String path="";
		path="E:/xp/test/2.jpg";
	}
}
