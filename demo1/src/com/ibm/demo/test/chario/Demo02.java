package com.ibm.demo.test.chario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class Demo02 {
	public static void main(String[] args) {
		File dest=new File("c:/aa/bb/cc/char.txt");
		Writer writer=null;
		try {
			writer=new FileWriter(dest,false);
			//写出
			String msg="2.主板: 华硕b150m-a/m.2 plus 579 599";
			writer.write(msg);
			writer.append("dsfasdfaf");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=writer){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
