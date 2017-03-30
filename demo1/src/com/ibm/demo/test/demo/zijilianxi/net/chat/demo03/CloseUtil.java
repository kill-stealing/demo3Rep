package com.ibm.demo.test.demo.zijilianxi.net.chat.demo03;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	
	public static void close(Closeable ... io){
		for(Closeable temp:io){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
