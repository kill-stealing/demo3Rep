package com.ibm.demo.test.demo.zijilianxi.net.url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	public static void main(String[] args) {
		try {
			URL url=new URL("http://www.baidu.com:80/index.html#aa?name=bjsxt");
			System.out.println("协议："+url.getProtocol());
			System.out.println("域名："+url.getHost());
			System.out.println("端口："+url.getPort());
			System.out.println("资源："+url.getFile());
			System.out.println("相对路径："+url.getPath());
			System.out.println("锚点："+url.getRef());
			System.out.println("参数："+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
