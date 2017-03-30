package com.ibm.demo.test.io.file;

import java.io.File;
import java.util.Arrays;

/*
 * 输出子孙级目录及文件的名称
 * 1.listFiles()
 * 2.递归
 */
public class Demo05 {

	public static void main(String[] args) {
		String pathString="C:/aa";
		File[] roots=File.listRoots();
		System.out.println(Arrays.toString(roots));
		for(File temp:roots){
			listFile(temp.getPath(),0);
		}
//		int level=0;
//		listFile(pathString,level);
	}
	
	public static void listFile(String path,int level){
		level++;
		File src=new File(path);
		File[] fileList=src.listFiles();
		for(File temp:fileList){
			String string="";
			for(int i=1;i<level;i++){
				string=string+"-";
			}
			System.out.println(string+temp.getName());
			String name=temp.getPath();
			if(temp.isFile()){
			}else{
				listFile(name,level);
			}
		}
	}

}
