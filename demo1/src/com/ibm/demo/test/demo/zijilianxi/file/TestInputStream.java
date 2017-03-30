package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class TestInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:/aa/bb/cc/1.txt");
		read2(file);
	}
	
	public static void read2(File file){
		BufferedReader in=null;
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
			byte[] flush=new byte[1024];
			int len=0;
			String str="";
			while(null!=(str=in.readLine())){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=in){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void read1(File file){
		InputStream in=null;
		try {
			in=new FileInputStream(file);
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=in.read(flush))){
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=in){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
