package com.ibm.demo.test.demo.classloadprocess1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具
 * @author liumy
 *
 */
public class EncrptUtil {
	
	public static void main(String[] args) {
		encrpt("C:/myJava/HelloWorld.class", "C:/myJava/temp/HelloWorld.class");
	}
	
	public static void encrpt(String src,String dest){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(src);
			fos=new FileOutputStream(dest);
			int temp=-1;
			while(-1!=(temp=fis.read())){
				fos.write(temp^0xff); //取反操作
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
