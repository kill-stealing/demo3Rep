package com.ibm.demo.test.demo.zijilianxi.net.url;

import java.io.Closeable;
import java.io.IOException;

public class TestCloseable {

	public static void main(String[] args) {
		
	}
	
	public static void close(Closeable ... t){
		for(Closeable temp:t){
			try {
				if(null!=temp){
					temp.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static <T extends Closeable> void closeAll(T ... t){
		for(Closeable temp:t){
			try {
				if(null!=temp){
					temp.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
