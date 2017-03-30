package com.ibm.demo.test.demo.netdevelop.chat.demo01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * @author liumy
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(9999);
			Socket client=server.accept();
			
			
			//写出数据
			//输入流
			DataInputStream dis=new DataInputStream(client.getInputStream());
			String msg=dis.readUTF();
			
			// 输出流
			DataOutputStream dos = new DataOutputStream(
					client.getOutputStream());
			dos.writeUTF("服务器--》"+msg);
			dos.flush();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
