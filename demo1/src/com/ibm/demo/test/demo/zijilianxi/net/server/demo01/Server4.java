package com.ibm.demo.test.demo.zijilianxi.net.server.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
	private ServerSocket server;
	
	public static final String CRLF="\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		Server4 server=new Server4();
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
			Request req=new Request(client.getInputStream());
			
			// 响应
			Response rep=new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP响应示例</title></head>");
			rep.println("<body>Hello 111!</body></html>");
			rep.pushToClient(200);
			
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
