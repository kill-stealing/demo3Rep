package com.ibm.demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * Created by kaiyi.cky on 2015/8/16.
 */
public class FileUploader {
	private static final String TAG = "uploadFile";
	private static final int TIME_OUT = 10 * 10000000; // 超时时间
	private static final String CHARSET = "utf-8"; // 设置编码
	private static final String PREFIX = "--";
	private static final String LINE_END = "\r\n";

	private static final String UTF8 = "utf-8";

	// 申请者开发者id，实际使用时请修改成开发者自己的appid
	private static final String appId = "20160621000023746";

	// 申请成功后的证书token，实际使用时请修改成开发者自己的token
	private static final String token = "2XL_O4n2znVqkBl4gt0n";

	private static final String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";

	// 随机数，用于生成md5值，开发者使用时请激活下边第四行代码
	private static final Random random = new Random();

	public static String upload(String host, File file,
			Map<String, String> params, FileUploadListener listener) {
		String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成 String
														// PREFIX = "--" ,
														// LINE_END = "\r\n";
		String CONTENT_TYPE = "multipart/form-data"; // 内容类型
		String resultString = "";
		try {
			URL url = new URL(host);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(TIME_OUT);
			conn.setConnectTimeout(TIME_OUT);
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET);// 设置编码
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary="
					+ BOUNDARY);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			if (file != null) {
				/** * 当文件不为空，把文件包装并且上传 */
				OutputStream outputSteam = conn.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputSteam);
				StringBuffer sb = new StringBuffer();
				sb.append(LINE_END);
				if (params != null) {// 根据格式，开始拼接文本参数
					for (Map.Entry<String, String> entry : params.entrySet()) {
						sb.append(PREFIX).append(BOUNDARY).append(LINE_END);// 分界符
						sb.append("Content-Disposition: form-data; name=\""
								+ entry.getKey() + "\"" + LINE_END);
						sb.append("Content-Type: text/plain; charset="
								+ CHARSET + LINE_END);
						sb.append("Content-Transfer-Encoding: 8bit" + LINE_END);
						sb.append(LINE_END);
						sb.append(entry.getValue());
						sb.append(LINE_END);// 换行！
					}
				}
				sb.append(PREFIX);// 开始拼接文件参数
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				/**
				 * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
				 * filename是文件的名字，包含后缀名的 比如:abc.png
				 */
				sb.append("Content-Disposition: form-data; name=\"img\"; filename=\""
						+ file.getName() + "\"" + LINE_END);
				sb.append("Content-Type: application/octet-stream; charset="
						+ CHARSET + LINE_END);
				sb.append(LINE_END);
				// 写入文件数据
				dos.write(sb.toString().getBytes());
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				long totalbytes = file.length();
				long curbytes = 0;
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					curbytes += len;
					dos.write(bytes, 0, len);
					listener.onProgress(curbytes, 1.0d * curbytes / totalbytes);
				}
				is.close();
				dos.write(LINE_END.getBytes());// 一定还有换行
				byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END)
						.getBytes();
				dos.write(end_data);
				dos.flush();
				/**
				 * 获取响应码 200=成功 当响应成功，获取响应的流
				 */
				int code = conn.getResponseCode();
				sb.setLength(0);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				resultString=sb.toString();
				listener.onFinish(code, sb.toString(), conn.getHeaderFields());
				System.out.println("------"+resultString+"----");
				br.close();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultString;
	}

	public static String postMethod1(String param) {
		DataOutputStream out = null;
		BufferedReader in = null;
		String result = "";
		String from = "auto";
		try {
			URL realUrl = new URL("http://localhost:8080/helloworld");
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setReadTimeout(TIME_OUT);
			conn.setConnectTimeout(TIME_OUT);
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET);// 设置编码
			conn.setRequestProperty("connection", "keep-alive");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			
			out = new DataOutputStream(conn
	                .getOutputStream());
			
			JSONObject obj = new JSONObject();
			obj.element("type", "1");
			obj.element("type1Input", param);
			StringBuffer paramStringBuffer=new StringBuffer();
			paramStringBuffer.append("type=1&type1Input=").append(URLEncoder.encode(param,"UTF-8"));
			//param="type=1&type1Input="+"I have been assigned to handle your order status request."; 
			// 发送请求参数
			out.writeBytes(paramStringBuffer.toString());
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			InputStream insss = conn.getInputStream();
			 File f=new File("C:\\test\\English_shengcheng.wav");
			 inputstreamtofile(insss, f);
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static void inputstreamtofile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String postMethod(String param) {
		String result = "";
		int salt = random.nextInt(10000);
		String from = "auto";
		String to = "auto";
		String sign = md5(appId + param + salt + token);
		JSONObject obj = new JSONObject();
		obj.element("q", param);
		obj.element("appid", appId);
		obj.element("salt", String.valueOf(salt));
		obj.element("from", from);
		obj.element("to", to);
		obj.element("sign", sign);
		try {
			// Create the POST object and add the parameters
			HttpPost httpPost = new HttpPost(url);
			StringEntity entity = new StringEntity(obj.toString(), HTTP.UTF_8);
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity1 = response.getEntity();
				result = EntityUtils.toString(response.getEntity());
			}
			System.out.println(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static String transferMethod(String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		int salt = 1435660288;
		String from = "auto";
		String to = "auto";

		// 对appId+源文+随机数+token计算md5值
		StringBuilder md5String = new StringBuilder();
		md5String.append(appId).append(param).append(salt).append(token);
		String md5 = DigestUtils.md5Hex(md5String.toString());

		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setReadTimeout(TIME_OUT);
			conn.setConnectTimeout(TIME_OUT);
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET);// 设置编码
			conn.setRequestProperty("connection", "keep-alive");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			JSONObject obj = new JSONObject();
			obj.element("q", param);
			obj.element("appid", appId);
			obj.element("salt", String.valueOf(salt));
			obj.element("from", from);
			obj.element("to", to);
			obj.element("sign", md5);
			// 发送请求参数
			out.print(obj.toString());
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
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

	public interface FileUploadListener {
		public void onProgress(long pro, double precent);

		public void onFinish(int code, String res,
				Map<String, List<String>> headers);
	}

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("type", "speechToText");
		// FileUploader.upload("https://convertdemo.mybluemix.net/helloworld",
		// new File(
		// "C:\\test\\English.wav"), map,
		// new FileUploader.FileUploadListener() {
		// @Override
		// public void onProgress(long pro, double precent) {
		// System.out.println("precent " + precent);
		// }
		//
		// @Override
		// public void onFinish(int code, String res,
		// Map<String, List<String>> headers) {
		// System.out.println("res " + res);
		// }
		// });
		String text = "I have been assigned to handle your order status request. "
				+ "I am sorry to inform you that the items you requested are back-ordered. "
				+ "We apologize for the inconvenience. We don't know when those items will become available. "
				+ "Maybe next week but we are not sure at this time. "
				+ "Because we want you to be a happy customer, management has decided to give you a 50% discount!";
		String textString="多数浏览器对于POST采用两阶段发送数据的，先发送请求头，再发送请求体，即使参数再少再短，";
		
		String resultString1 = FileUploader.postMethod1(textString);

		// String resultString1=FileUploader.md5("hello");
		System.out.println(resultString1);
	}
}
