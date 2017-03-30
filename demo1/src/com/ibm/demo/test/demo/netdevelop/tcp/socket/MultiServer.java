package com.ibm.demo.test.demo.netdevelop.tcp.socket;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.创建服务器 指定端口 //
 * 2. 接收客户端连接 阻塞式 
 * 3.发送数据
 * 
 * 接收多个客户端
 * 
 * @author liumy
 *
 */
public class MultiServer {
	public static void main(String[] args) {
		try {
			// 1.创建服务器 指定端口 ServerSocket(int port)
			ServerSocket server = new ServerSocket(8888);
			while(true){//死循环 一个accept 一个客户端
				// 2. 接收客户端连接 阻塞式
				Socket socket = server.accept();
				// 3.发送数据
				String msg = "欢迎使用";
				// 4.输出流
				/*BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())
						);
				bw.write(msg);
				bw.newLine();
				bw.flush();*/
				DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
				dos.flush();
				System.out.println("一个客户端建立连接");
				
				while(true){
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
