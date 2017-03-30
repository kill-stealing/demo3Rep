package com.ibm.demo.test.demo.zijilianxi.net.server.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Request {
	//请求方式
	private String method;
	//请求资源
	private String url;
	//请求参数
	private Map<String,List<String>> parameterMapValues;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	private InputStream is;
	private String requestInfo;
	
	public Request() {
		method="";
		url="";
		parameterMapValues=new HashMap<String, List<String>>();
	}
	
	public Request(InputStream is) {
		this();
		this.is=is;
		byte[] data=new byte[20480];
		try {
			int len=is.read(data);
			requestInfo=new String(data,0,len);
		} catch (IOException e) {
			return;
		}
		//分析头信息
		parseRequestInfo();
	}
	
	private void parseRequestInfo(){
		if(null==requestInfo||requestInfo.trim().equals("")){
			return;
		}
		/*	GET /index.html?userName=111&pwd=fdsafa HTTP/1.1
			Host: localhost:8888
			Connection: keep-alive
			Cache-Control: max-age=0
			Upgrade-Insecure-Requests: 1
			User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36
			Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp;q=0.8
			Accept-Encoding: gzip, deflate, sdch, br
			Accept-Language: zh-CN,zh;q=0.8
		*/
		
		String paramString="";
		String firstLine=requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx=requestInfo.indexOf("/");
		this.method=firstLine.substring(0,idx).trim();
		String urlStr=firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
		if(this.method.equals("POST")){
			this.url=firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
			paramString=requestInfo.substring(requestInfo.indexOf(CRLF)).trim();
		}else if(this.method.equals("GET")){
			//是否存在参数
			if(urlStr.contains("?")){
				String[] urlArr=urlStr.split("?");
				this.url=urlArr[0];
				paramString=urlArr[1];
			}else{
				this.url=urlStr;
			}
		}
		
		//2.将请求参数封装到map中
		//不存在请求参数
		if(paramString.equals("")){
			return;
		}
		parseParams(paramString);
	}
	
	private void parseParams(String paramString){
		//分割
		StringTokenizer token=new StringTokenizer(paramString,"&");
		while(token.hasMoreTokens()){
			String keyValue=token.nextToken();
			String[] keyValues=keyValue.split("=");
			if(keyValues.length==1){
				keyValues=Arrays.copyOf(keyValues, 2);
				keyValues[1]=null;
			}
			
			String key=keyValues[0].trim();
			String value= null==keyValues[1]?null:decode(keyValues[1].trim(), "utf-8");
			
			//转换成Map 分拣
			if(!parameterMapValues.containsKey(key)){
				parameterMapValues.put(key, new ArrayList<String>());
			}
			List<String> valList=parameterMapValues.get(key);
			valList.add(value);
		}
		System.out.println(parameterMapValues);
	}
	
	/**
	 * 根据页面的name 获取对应的值
	 * @return
	 */
	public String getParameter(String name){
		String[] values=getParameterValues(name);
		if(null==values){
			return null;
		}
		return values[0];
	}
	
	/**
	 * 根据页面的name 获取对应的多个值
	 * @return
	 */
	public String[] getParameterValues(String name){
		List<String> values=null;
		if((values=parameterMapValues.get(name))==null){
			return null;
		}else{
			return values.toArray(new String[0]);
		}
	}
	
	private String decode(String value,String code){
		try {
			return java.net.URLDecoder.decode(value,code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
