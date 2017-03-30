package com.ibm.demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/helloworld")
@MultipartConfig
public class HelloWorldServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String typeString=request.getParameter("type");
		System.out.println("typeString "+typeString);
		if(typeString.equals("test")){
			Part part = request.getPart("img");
			part.getSize();
			if(part.getSize()==0l){
				response.sendRedirect("/NewFile.html");
				return;
			}
			{
				part.write("C:\\test\\English_test.wav");
				VisualRecognitionTest2 test2=new  VisualRecognitionTest2();
				String resultString=test2.postmethod2(part.getInputStream());
				response.getWriter().println(resultString);
			}
		}else if(typeString.equals("speechToTextNoBr")){
			Part part = request.getPart("img");
			part.getSize();
			if(part.getSize()==0l){
				response.sendRedirect("/NewFile.html");
				return;
			}
			String language=request.getParameter("language");
			SpeechToTextTest speechToTextTest=new SpeechToTextTest();
			List<String> resultList=speechToTextTest.speToTe(language,part.getInputStream());
			response.setCharacterEncoding("UTF-8");
			for (String result : resultList) {
				response.getWriter().println(result+".");
			}
		}else if(typeString.equals("speechToText")){
			Part part = request.getPart("img");
			part.getSize();
			if(part.getSize()==0l){
				response.sendRedirect("/NewFile.html");
				return;
			}
			String language=request.getParameter("language");
			SpeechToTextTest speechToTextTest=new SpeechToTextTest();
			List<String> resultList=speechToTextTest.speToTe(language,part.getInputStream());
			response.setCharacterEncoding("UTF-8");
			System.out.println(" response "+response.getCharacterEncoding());
			System.out.println(" response "+response.getContentType());
			for (String result : resultList) {
				response.getWriter().println(result+"<br>");
			}
			
		}else if(typeString.equals("0")){
			Part part = request.getPart("file1");
			part.getSize();
			if(part.getSize()==0l){
				response.sendRedirect("/NewFile.html");
				return;
			}
			SpeechToTextTest speechToTextTest=new SpeechToTextTest();
			List<String> resultList=speechToTextTest.speToTe("en-US_BroadbandModel",part.getInputStream());
			response.getWriter().println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
			for (String result : resultList) {
				response.getWriter().println(result+"<br>");
			}
		}else if(typeString.equals("1")){
			String textToSpeString=request.getParameter("type1Input");
			TextToSpeechTest teToSpe=new TextToSpeechTest();
			InputStream inputStream=teToSpe.teToSpe(textToSpeString);
			 //取得输出流
            ServletOutputStream out = response.getOutputStream();
            int BUFFER = 1024*10;
            byte data[] = new byte[BUFFER];
            BufferedInputStream bis = null;
            int read;
            bis = new BufferedInputStream(inputStream,BUFFER);
            response.setContentType("application/OCTET-STREAM");
            // 文件名可以任意指定， 本例中输出的文件名为 test.zip,
            response.setHeader("Content-Disposition","attachment; filename="+"teToSpe.wav;");        
            while((read = bis.read(data)) != -1){
                out.write(data, 0, read);
            }
            inputStream.close();
            bis.close();
		}else if(typeString.equals("2")){
			String translateString=request.getParameter("type2Input");
			LanguageTranslationTest lanTest=new LanguageTranslationTest();
			String result=lanTest.languageTranslationMethod(translateString);
			response.getWriter().println(result);
		}else if(typeString.equals("imgTransfer")){
			
		}
		
	}

	/**
	 * 根据请求头解析出文件名 请求头的格式：火狐和google浏览器下：form-data; name="file";
	 * filename="snmp4j--api.zip" IE浏览器下：form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header
	 *            请求头
	 * @return 文件名
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 =
		 * header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：
		 * tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(
				tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}
}
