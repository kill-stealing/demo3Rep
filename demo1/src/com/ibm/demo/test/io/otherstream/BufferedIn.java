package com.ibm.demo.test.io.otherstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 封装输入
 * @author liumy
 *
 */
public class BufferedIn {

	public static void main(String[] args) {
		InputStream in=System.in;
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		System.out.println("请输入。。。。");
		String msg=null;
		try {
			msg = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
	}

}
