package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestCopyFileCatalog {

	public static void main(String[] args) {
		String srcPath="C:/aa/bb/cc/1.txt";
		String destPath="C:/bb1.txt";
		File src=new File(srcPath);
		File dest=new File(destPath);
		if(src.isDirectory()){
			dest=new File(destPath,src.getName());
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				return;
			}
		}
		copyList(src,dest);
	}
	
	public static void copyList(File src,File dest){
		if(src.isFile()){
			copyFile(src,dest);
		}else if(src.isDirectory()){
			dest.mkdirs();
			File[] srcList=src.listFiles();
			for(File srcF:srcList){
				copyList(srcF,new File(dest,srcF.getName()));
			}
		}
	}
	
	public static void copyFile(File src,File dest){
		InputStream in=null;
		OutputStream out=null;
		
		if(!src.isFile()){
			System.out.println("只能拷贝文件");
			return;
		}
		//如果dest为已经存在的文件夹，不能建立与文件夹同名的文件
		if(dest.isDirectory()){
			System.out.println("不能建立与文件夹同名的文件"+dest.getName());
			return;
		}
		try {
			in=new FileInputStream(src);
			out=new FileOutputStream(dest);
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
