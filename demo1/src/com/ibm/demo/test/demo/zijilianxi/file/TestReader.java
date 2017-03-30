package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("C:/aa/bb/cc/2.txt");
		Reader r=null;
		try {
			r=new FileReader(f);
			char[] flush=new char[1024];
			int len=0;
			while(-1!=(len=r.read(flush))){
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null!=r){
				try {
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
