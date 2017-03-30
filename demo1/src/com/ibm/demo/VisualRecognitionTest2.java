package com.ibm.demo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class VisualRecognitionTest2 {
	public static void main(String[] args) {
		/*VisualRecognitionTest2 test1 = new VisualRecognitionTest2();
		String filePath = "C:\\test4.jpg";
		File file=new File(filePath);
		InputStream ins;
		try {
			ins = new FileInputStream(file);
			test1.postmethod2(ins);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		VisualRecognitionTest2 test1 = new VisualRecognitionTest2();
		String filePath = "C:\\test\\English.wav";
		File file=new File(filePath);
		InputStream ins;
		
		String filePath1 = "C:\\test6.jpg";
		File file1=new File(filePath1);
		InputStream ins1;
		try {
//			ins = new FileInputStream(file);
//			test1.postmethod3(ins);
			
			ins1 = new FileInputStream(file1);
			test1.postmethod2(ins1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 * public void postMethod1() { // 定义请求url String uri = "www.myhost.com";
	 * 
	 * // 实例化http客户端 HttpClient httpClient = new DefaultHttpClient(); //
	 * 实例化post提交方式 HttpPost post = new HttpPost(uri);
	 * 
	 * // 添加json参数 try { // 实例化参数对象 MultipartEntity params = new
	 * MultipartEntity();
	 * 
	 * // 图片文本参数 params.addPart("textParams", new StringBody(
	 * "{'user_name':'我的用户名','channel_name':'却道明','channel_address':'(123.4,30.6)'}"
	 * , Charset.forName("UTF-8"))); String fileName=""; // 设置上传文件 File file =
	 * new File(fileName); // 文件参数内容 FileBody fileBody = new FileBody(file); //
	 * 添加文件参数 params.addPart("photo", fileBody); params.addPart("photoName", new
	 * StringBody(file.getName())); // 将参数加入post请求体中 post.setEntity(params);
	 * 
	 * // 执行post请求并得到返回对象 [ 到这一步我们的请求就开始了 ] httpClient.execute(post);
	 * 
	 * // 解析返回请求结果 HttpEntity entity = resp.getEntity(); InputStream is =
	 * entity.getContent(); BufferedReader reader = new BufferedReader(new
	 * InputStreamReader(is)); StringBuffer buffer = new StringBuffer(); String
	 * temp;
	 * 
	 * while ((temp = reader.readLine()) != null) { buffer.append(temp); }
	 * 
	 * System.out.println(buffer);
	 * 
	 * } catch (UnsupportedEncodingException e) { e.printStackTrace(); } catch
	 * (ClientProtocolException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); } catch (IllegalStateException e) {
	 * e.printStackTrace(); } }
	 */

	public String postmethod2(InputStream inss) {
		String str = "https://watson-api-explorer.mybluemix.net/visual-recognition/api/v3/recognize_text?api_key=a76710f44212efbe5d5fddecbda8f667ce0a0cde&version=2016-05-19";
//		String filePath = "C:\\test4.jpg";
		InputStream ins = null;
		String resultString2="";
		try {
			URL url = new URL(str);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("content-type", "text/html");
//			BufferedOutputStream out = new BufferedOutputStream(
//					connection.getOutputStream());
			
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());

			// 读取文件上传到服务器
//			File file = new File(filePath);
//			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int numReadByte = 0;
			while ((numReadByte = inss.read(bytes, 0, 1024)) > 0) {
				out.write(bytes, 0, numReadByte);
			}

			out.flush();
			inss.close();
			// 读取URLConnection的响应
			DataInputStream in = new DataInputStream(
					connection.getInputStream());
			ins = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ins,
					"UTF-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while (null != (line = br.readLine())) {
				buffer.append(line).append("\n");
			}
			String resultString = buffer.toString();
			System.out.println(resultString);
			JSONObject dataJson = JSONObject.fromObject(resultString);
			JSONArray response = dataJson.getJSONArray("images");
			
			JSONArray data = response.getJSONObject(0).getJSONArray("words");
			
			for(int i=0;i<data.size();i++){
				resultString2=resultString2+data.getJSONObject(i).getString("word")+" ";
			}
			// {
			// "images": [
			// {
			// "text": "[tea] hands",
			// "words": [
			// {
			// "line_number": 0,
			// "location": {
			// "height": 76,
			// "left": 87,
			// "top": 192,
			// "width": 163
			// },
			// "score": 0.40142099999999999,
			// "word": "tea"
			// },
			// {
			// "line_number": 0,
			// "location": {
			// "height": 86,
			// "left": 281,
			// "top": 192,
			// "width": 281
			// },
			// "score": 0.986078,
			// "word": "hands"
			// }
			// ]
			// }
			// ],
			// "images_processed": 1
			// }
			System.out.println(resultString2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ins.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultString2;
	}
	
	public String postmethod3(InputStream inss) {
		String str = "http://localhost:8080/helloworld";
		InputStream ins = null;
		String resultString2="";
		try {
			URL url = new URL(str);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			
			connection.setRequestProperty("Content-Type","multipart/form-data;boundary=" + "0");
			
			//connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			// 读取文件上传到服务器
			byte[] bytes = new byte[1024];
			int numReadByte = 0;
			while ((numReadByte = inss.read(bytes, 0, 1024)) > 0) {
				out.write(bytes, 0, numReadByte);
			}
			 String content = "type=" + URLEncoder.encode("一个大肥人", "UTF-8");
			out.writeBytes(content);
			out.flush();
			inss.close();
			// 读取URLConnection的响应
			ins = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ins,
					"UTF-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while (null != (line = br.readLine())) {
				buffer.append(line).append("\n");
			}
			resultString2 = buffer.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ins.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultString2;
	}

}
