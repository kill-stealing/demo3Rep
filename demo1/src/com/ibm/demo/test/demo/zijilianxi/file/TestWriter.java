package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestWriter {

	public static void main(String[] args) {
		File f=new File("C:/aa/bb/cc/3.txt");
		Writer w=null;
		try {
			w=new FileWriter(f);
			String len="hello world\r\n 你好吗世界";
			char[] flush=len.toCharArray();
			w.write(flush);
			w.append("\r\n锄禾日当午");
			w.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(null!=w){
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
