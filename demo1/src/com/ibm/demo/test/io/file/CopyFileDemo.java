package com.ibm.demo.test.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class CopyFileDemo {
	public static void main(String[] args) throws IOException {
		String srcPath="C:/aa/bb/cc/1.png";
		String destPath="C:/aa/bb/cc/3.png";
		FileUtil.copyFile(srcPath, destPath);
	}
	
	
}
