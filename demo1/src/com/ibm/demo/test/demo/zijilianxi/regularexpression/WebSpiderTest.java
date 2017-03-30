package com.ibm.demo.test.demo.zijilianxi.regularexpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫链接
 * @author liumy
 *
 */
public class WebSpiderTest {
	
	public static void main(String[] args) {
		String destStr=getURLContent("http://www.163.com");
		System.out.println(destStr);
		List<String> list=getMatcherSubstr(destStr, "href=\"(.+?)\"");
		for(String temp:list){
			System.out.println(temp);
		}
	}
	
	public static List<String> getMatcherSubstr(String destStr,String regexStr){
		List<String> list=new ArrayList<String>();
//		Pattern p=Pattern.compile("<a[\\d\\D]+?</a>");
		Pattern p=Pattern.compile(regexStr);
		Matcher m=p.matcher(destStr);
		while(m.find()){
			list.add(m.group(1));
		}
		return list;
	}
	
	/**
	 * 获得urlStr对应的网页的源码内容
	 * @param urlStr
	 * @return
	 */
	public static String getURLContent(String urlStr){
		StringBuilder sb=new StringBuilder();
		try {
			URL url=new URL(urlStr);
			BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"gbk"));
			String str="";
			while((str=br.readLine())!=null){
				sb.append(str).append("\r\n");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
