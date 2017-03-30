package com.ibm.demo.test.chario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyFileDemo {
	public static void main(String[] args) {
		File src=new File("C:/aa/bb/cc/char.txt");
		File dest=new File("C:/aa/bb/cc/dest.txt");
		Reader reader=null;
		Writer writer=null;
		try {
			reader=new FileReader(src);
			writer=new FileWriter(dest);
			char[] flush=new char[1024];
			int len=0;
			while(-1!=(len=reader.read(flush))){
				writer.write(flush, 0, len);
			}
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
