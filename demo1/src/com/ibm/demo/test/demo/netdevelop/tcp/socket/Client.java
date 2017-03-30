package com.ibm.demo.test.demo.netdevelop.tcp.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1.创建客户端，必须指定服务器+端口 此时就在连接 2.接收数据
 * 
 * @author liumy
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			// 1.创建客户端，必须指定服务器+端口 此时就在连接
			Socket client = new Socket("localhost", 8888);
			// 2.接收数据
			/*BufferedReader br = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String echo=br.readLine();//阻塞式 方法*/
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			String echo=dis.readUTF();
			System.out.println(echo);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
