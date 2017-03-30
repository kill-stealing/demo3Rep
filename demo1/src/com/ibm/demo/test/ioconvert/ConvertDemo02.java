package com.ibm.demo.test.ioconvert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 转换流：字节转为字符 1.输出流 outputStreamWriter 编码 2.输入流 InputStreamReader 解码
 * 
 * @author liumy
 *
 */
public class ConvertDemo02 {
	public static void main(String[] args) throws IOException {
		// 指定解码字符集
		BufferedReader brBufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(
						"c:/aa/bb/cc/1.txt")), "GBK"));
		String infoString = null;

		// 写出文件
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File("c:/aa/bb/cc/buffer.txt"))));
		while (null != (infoString = brBufferedReader.readLine())) {
			bWriter.write(infoString);
			bWriter.newLine();
		}
		bWriter.flush();
		bWriter.close();
		brBufferedReader.close();
	}
}
