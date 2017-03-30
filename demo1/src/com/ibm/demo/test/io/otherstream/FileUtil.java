package com.ibm.demo.test.io.otherstream;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	/**
	 * 工具类关闭流
	 * 可变参数 ... 只能放在形参的	最后一个位置
	 */
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
	
	public static <T extends Closeable> void closeAll(T ... io){
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
