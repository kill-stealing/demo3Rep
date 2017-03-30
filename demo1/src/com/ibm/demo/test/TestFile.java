package com.ibm.demo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TestFile {
	public static void printFileDir(File file,int a){
		for(int i=0;i<a;i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] list=file.listFiles();
			for(File file1:list){
				printFileDir(file1,a+1);
			}
		}
	}
	
	public static void main(String[] args) {
		File file=new File("C:/");
		printFileDir(file,0);
	}
	
	/*public static void main(String[] args) {
		File file=new File("C:/aa/");
		
		printTree(file,0);
	}
	
	public static void printTree(File file,int level){
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] fileListFiles=file.listFiles();
			for (File file2 : fileListFiles) {
				printTree(file2,level+1);
			}
		}
	}*/
	
	/*public static void main(String[] args) {
		try {
			FileReader fileReader=new FileReader("c:/aa");
			char c=(char) fileReader.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
}
