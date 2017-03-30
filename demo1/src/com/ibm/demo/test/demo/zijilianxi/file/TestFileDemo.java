package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.File;


public class TestFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:/aa";
		printFileName(0,path);
	}
	
	public static void printFileName(int level,String path){
		File src=new File(path);
		File[] listFiles=src.listFiles();
		for(File f:listFiles){
			for(int i=0;i<level;i++){
				System.out.print("-");
			}
			System.out.println(f.getAbsolutePath());
			if(f.isDirectory()){
				printFileName(++level,f.getAbsolutePath());
			}else{
				
			}
		}
	}

}
