package com.ibm.demo.test.demo.zijilianxi.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建
 * 
 * 接收多个客户端
 * @author liumy
 *
 */
public class MultiServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//创建服务器
			ServerSocket server=new ServerSocket(8888);
			//接收客户端连接 阻塞式
			while(true){
				Socket socket=server.accept();
				System.out.println("一个客户端建立连接");
				String msg="欢迎使用";
				DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
				dos.flush();
				
				while(true){
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
