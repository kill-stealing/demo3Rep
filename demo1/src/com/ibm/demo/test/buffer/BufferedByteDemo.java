package com.ibm.demo.test.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * 字节流文件拷贝+缓冲流 提高性能
 */
public class BufferedByteDemo {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String src="C:/aa/bb/cc/1.png";
		String dest="C:/aa/bb/cc/10.png";
		File srcFile=new File(src);
		File destFile=new File(dest);
		if(srcFile.isFile()){
			InputStream isInputStream=new BufferedInputStream(new FileInputStream(srcFile));
			OutputStream out=new BufferedOutputStream(new FileOutputStream(destFile));
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=isInputStream.read(flush))){
				out.write(flush, 0, len);
			}
			out.flush();
			out.close();
			isInputStream.close();
		}
	
	}
}
