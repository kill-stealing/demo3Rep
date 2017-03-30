package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class TestCopyFilebyWriter {
	public static void main(String[] args) {
		File src=new File("C:/aa/bb/cc/1.txt");
		File dest=new File("C:/aa/bb/cc/12.txt");
		Reader r=null;
		Writer w=null;
		try {
			r=new FileReader(src);
			w=new FileWriter(dest);
			int len=0;
			char[] flush=new char[1024];
			while(-1!=(len=r.read(flush))){
				w.write(new String(flush,0,len));
			}
			w.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
			if(null!=w){
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
