package com.ibm.demo.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Test0125 {
	public static void main(String[] args) {
		String path="C:/myJava/test.txt";
		try {
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(path));
			
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"GBK"));
			String str="";
			int i=0;
			while(null!=(str=br.readLine())){
				if(i>15500&&i<16500){
					System.out.println(br.readLine());
					System.out.println("                    ");
				}
				i++;
			}
			br.close();
			bis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
