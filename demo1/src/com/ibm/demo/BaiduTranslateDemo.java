package com.ibm.demo;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;







import net.sf.json.JSONArray;

import org.apache.catalina.core.ApplicationContext;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * 百度翻译引擎java示例代码
 */
public class BaiduTranslateDemo{
	
	private static final String UTF8 = "utf-8";
	
	//申请者开发者id，实际使用时请修改成开发者自己的appid
	private static final String appId = "20160621000023746";

	//申请成功后的证书token，实际使用时请修改成开发者自己的token
	private static final String token = "2XL_O4n2znVqkBl4gt0n";

	private static final String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";

	//随机数，用于生成md5值，开发者使用时请激活下边第四行代码
	private static final Random random = new Random();
	
	public String translate(String q, String from, String to) throws Exception{
		//用于md5加密
		//int salt = random.nextInt(10000);
		//本演示使用指定的随机数为1435660288
		int salt = 1435660288;
		String text="";
		// 对appId+源文+随机数+token计算md5值
		StringBuilder md5String = new StringBuilder();
		md5String.append(appId).append(q).append(salt).append(token);
		String md5 = DigestUtils.md5Hex(md5String.toString());
		
		String sign = md5(appId + q + salt + token);

		//使用Post方式，组装参数
		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
		nvps.add(new BasicNameValuePair("q", q));  
		   nvps.add(new BasicNameValuePair("from", from));  
		   nvps.add(new BasicNameValuePair("to", to));  
		   nvps.add(new BasicNameValuePair("appid", appId));  
		   nvps.add(new BasicNameValuePair("salt", String.valueOf(salt)));  
		   nvps.add(new BasicNameValuePair("sign", md5));  
		httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));  

		//创建httpclient链接，并执行
	    CloseableHttpClient httpclient = HttpClientBuilder.create().build();
	    CloseableHttpResponse response = httpclient.execute(httpost);
	    
	    //对于返回实体进行解析
		HttpEntity entity = response.getEntity();
		InputStream returnStream = entity.getContent();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(returnStream, UTF8));
		StringBuilder result = new StringBuilder();
		String str = null;
		while ((str = reader.readLine()) != null) {
			result.append(str).append("\n");
		}
		
		return result.toString();
	}
	
	public static String md5(String str) {
		String s = str;
		if (s == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {

			}
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
			} catch (Exception ex) {
			}
			return value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BaiduTranslateDemo baidu=new BaiduTranslateDemo();
		String result = null;
		try {
			result = baidu.translate("hello", "auto", "auto");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
