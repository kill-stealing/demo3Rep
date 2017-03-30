package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:/aa/bb/cc/2.txt");
		OutputStream os=null;
		try {
			os=new FileOutputStream(file,true);
			String str="hello world!";
			byte[] b=str.getBytes();
			os.write(b,0,b.length);
			os.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=os){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
