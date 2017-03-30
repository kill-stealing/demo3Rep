package com.ibm.demo.test.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestCopyFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src="C:/aa/bb/cc/1.png";
		String dest="C:/aa/bb/cc/10.png";
		File srcFile=new File(src);
		File destFile=new File(dest);
		if(srcFile.isFile()){
			try(
				InputStream isInputStream=new FileInputStream(srcFile);
				OutputStream out=new FileOutputStream(destFile);
			)
			{
				byte[] flush=new byte[1024];
				int len=0;
				while(-1!=(len=isInputStream.read(flush))){
					out.write(flush, 0, len);
				}
				out.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
//			com.ibm.demo.test.io.otherstream.FileUtil.close(out,isInputStream);
		}
	}

}
