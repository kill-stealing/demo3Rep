package com.ibm.demo.test.demo.zijilianxi.net.chat.demo01;

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

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(9999);
		Socket client=server.accept();
		//读取数据
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String msg=dis.readUTF();
		System.out.println(msg);
		//输出数据
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("服务器数据-》"+msg);
		dos.flush();
		
	}

}
