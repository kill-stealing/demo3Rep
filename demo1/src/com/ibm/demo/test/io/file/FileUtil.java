package com.ibm.demo.test.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	/*
	 * @param 源文件路径
	 * @param 目录文件路径
	 * @param 
	 */
	public static void copyFile(String srcPath,String destPath)throws IOException {

		//1.建立联系
		File src=new File(srcPath);
		File dest=new File(destPath);
		copyFile(src, dest);
	}
	
	public static void copyFile(File src,File dest)throws IOException {
		if(!src.isFile()){
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		//2,选择流
		InputStream isInputStream=new FileInputStream(src);
		OutputStream outputStream=new FileOutputStream(dest);
		//3.文件拷贝 循环+读取+写出
		byte[] flush=new byte[1024];
		int len=0;
		//读取
		while (-1!=(len=isInputStream.read(flush))) {
			//写出
			outputStream.write(flush,0,len);
		}
		outputStream.flush();//强制刷出
		//关闭流 先打开的后关闭
		outputStream.close();
		isInputStream.close();
	}

}
