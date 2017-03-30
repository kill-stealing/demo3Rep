package com.ibm.demo.test.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/*
 * 字符缓冲流  +新增方法 （不能发生多态）
 */
public class BufferedCharDemo {
	public static void main(String[] args) {
		File src=new File("C:/aa/bb/cc/char.txt");
		File dest=new File("C:/aa/bb/cc/dest.txt");
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			reader=new BufferedReader(new FileReader(src));
			writer=new BufferedWriter(new FileWriter(dest));
			String line=null;
			while(null!=(line=reader.readLine())){
				writer.write(line);
				//writer.append("\r\n");
				writer.newLine();//换行符
			}
			/*char[] flush=new char[1024];
			int len=0;
			while(-1!=(len=reader.read(flush))){
				writer.write(flush, 0, len);
			}*/
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				writer.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
