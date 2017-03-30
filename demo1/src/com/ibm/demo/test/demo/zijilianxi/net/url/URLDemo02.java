package com.ibm.demo.test.demo.zijilianxi.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo02 {

	public static void main(String[] args) {
		URL url=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			url= new URL("http://www.baidu.com");
			br = new BufferedReader(new InputStreamReader(
					url.openStream(),"UTF-8"));
			bw=new BufferedWriter(new FileWriter(new File("c:/aa/bb/cc/10.txt")));
			String str="";
			while(null!=(str=br.readLine())){
				bw.write(str);
			}
			bw.flush();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			TestCloseable.close(br,bw);
		}
	}

}
