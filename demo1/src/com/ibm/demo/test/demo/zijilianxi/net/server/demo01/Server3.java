package com.ibm.demo.test.demo.zijilianxi.net.server.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
	private ServerSocket server;
	
	public static final String CRLF="\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		Server3 server=new Server3();
		server.start();
	}
	
	/**
	 * 启动方法
	 */
	public void start(){
		try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 接收客户端
	 */
	private void receive(){
		try {
			Socket client=server.accept();
			StringBuilder sb=new StringBuilder();
			String msg=null;
			
			//接收客户端的请求信息
			byte[] data=new byte[20480];
			int len=client.getInputStream().read(data);
			String requestInfo=new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			// 响应
			Response rep=new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP响应示例</title></head>");
			rep.println("<body>Hello 111!</body></html>");
			rep.pushToClient(404);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 停止
	 */
	public void stop(){
		
	}

}
