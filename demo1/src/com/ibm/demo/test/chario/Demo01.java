package com.ibm.demo.test.chario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo01 {
	public static void main(String[] args) {
		//创建源
		File src=new File("C:/aa/bb/cc/utf.txt");
		//选择流
		Reader reader=null;
		try {
			reader=new FileReader(src);
			//读取操作
			char[] flush=new char[1024];
			int len=0;
			while(-1!=(len=reader.read(flush))){
				String string=new String(flush,0,len);
				System.out.println(string);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
