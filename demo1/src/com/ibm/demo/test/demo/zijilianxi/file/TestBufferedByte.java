package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestBufferedByte {

	public static void main(String[] args) {
		File src=new File("C:/aa/bb/cc/1.png");
		File dest=new File("C:/aa/bb/cc/11.png");
		InputStream in=null;
		OutputStream out=null;
		try {
			in=new BufferedInputStream(new FileInputStream(src));
			out=new BufferedOutputStream(new FileOutputStream(dest));
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=in.read(flush))){
				out.write(flush, 0, len);
			}
			out.flush();
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
			if(null!=out){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
