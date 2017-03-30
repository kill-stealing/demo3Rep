package com.ibm.demo.test.io.pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 文件的分割思路
 * 1.分割的块数
 * 2.每一块的大小 blockSize
 * @author liumy
 *
 */
public class RandDemo01 {

	public static void main(String[] args) {
		try {
			RandomAccessFile rnd = new RandomAccessFile(new File(
					"C:/aa/bb/cc/1.txt"), "r");
			
			rnd.seek(10);
			
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=rnd.read(flush))){
				if(len>=10){
					System.out.println(new String(flush,0,10));
				}else{
					System.out.println(new String(flush,0,len));
				}
				
			}
			rnd.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
