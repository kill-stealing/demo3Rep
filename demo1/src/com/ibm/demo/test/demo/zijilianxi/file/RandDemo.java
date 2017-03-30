package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandDemo {

	public static void main(String[] args) {
		try {
			RandomAccessFile r = new RandomAccessFile(new File(
					"C:/aa/bb/cc/1.txt"), "r");
			r.seek(10);
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=r.read(flush))){
				if(len>=10){
					System.out.println(new String(flush,0,10));
				}else{
					System.out.println(new String(flush,0,len));
				}
			}
			r.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
