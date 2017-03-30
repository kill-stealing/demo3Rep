package com.ibm.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="DownloadFileServlet",urlPatterns="/downloadFile")
public class DownloadFileServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) {
		File file=new File("C:\\test4.jpg");
		response.addHeader("content-disposition", "attachment;filename=aaa.jpg");
		InputStream inputStream=null;
		OutputStream outputStream=null;
		try {
			inputStream=new FileInputStream(file);
			outputStream=response.getOutputStream();
			int len=0;
			//创建数据缓冲区
			byte[] buffer=new byte[1024];
			while ((len=inputStream.read(buffer))>0) {
				outputStream.write(buffer, 0, len);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
