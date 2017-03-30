package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestConvertStream {

	public static void main(String[] args) {
		
		//
		ArrayList<String> list1=new ArrayList<String>();
		LinkedList<String> list2=new LinkedList<String>();
		String str1="中国";
		byte[] data=str1.getBytes();
		
		File f = new File("C:/aa/bb/cc/1.txt");
		BufferedReader br=null;
		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(f),"GBK"));
			String str="";
			while(null!=(str=br.readLine())){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
