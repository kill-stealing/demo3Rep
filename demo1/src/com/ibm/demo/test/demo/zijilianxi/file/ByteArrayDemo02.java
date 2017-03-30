package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件-->字节数组
 * 字节数组--》文件
 * @author liumy
 *
 */
public class ByteArrayDemo02 {
	public static void main(String[] args) {
		File src=new File("C:/aa/bb/cc/1.txt");
		File dest=new File("C:/aa/bb/cc/5.txt");
		InputStream in=null;
		ByteArrayInputStream bis=null;
		ByteArrayOutputStream bos=null;
		OutputStream out=null;
		byte[] data;
		try {
			in=new BufferedInputStream(new FileInputStream(src));
			bos=new ByteArrayOutputStream();
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=in.read(flush))){
				bos.write(flush, 0, len);
			}
			bos.flush();
			data=bos.toByteArray();
			
			bis=new ByteArrayInputStream(data);
			flush=new byte[1024];
			len=0;
			out=new BufferedOutputStream(new FileOutputStream(dest));
			while(-1!=(len=bis.read(flush))){
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
			if(null!=bis){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=bos){
				try {
					bos.close();
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
	
	public static void read(){
		
	}
}
