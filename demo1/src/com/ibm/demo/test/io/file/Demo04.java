package com.ibm.demo.test.io.file;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.FileFileFilter;
/*
 * list() 返回目录名称 string数组
 * 
 */
public class Demo04 {
	public static void main(String[] args) {
		test1();
		String pathString="C:/eclipse 7.1";
		File src=new File(pathString);
		if(src.isDirectory()){
			//返回子目录或者文件名称
			System.out.println("---返回子目录或者文件名称------");
			String[] subname=src.list();
			for(String temp:subname){
				System.out.println(temp);
			}
			System.out.println("---返回子目录或者文件 file对象------");
			//命令设计模式
			File[] files=src.listFiles(new FilenameFilter() {
				@Override
				/*
				 * dir 代表src
				 */
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
//					System.out.println(dir.getAbsolutePath());
//					return new File(dir,name).isFile()&&name.endsWith(".xml");
					return new File(dir,name).isFile()&&name.endsWith(".xml");
				}
			});
			
			System.out.println("ddddddddddddd");
			for(File temp:files){
				System.out.println(temp.getAbsolutePath());
			}
			
		}
	}
	
	public static void test1(){

		String pathString="C:/aa/cc/test/cc";
		File src=new File(pathString);
		src.mkdirs();
	
	}
}	
