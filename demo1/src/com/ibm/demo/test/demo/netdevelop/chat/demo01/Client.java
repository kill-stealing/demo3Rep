package com.ibm.demo.test.demo.netdevelop.chat.demo01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端：发送数据+接收数据 
 * 写出数据：输出流 
 * 读取数据：输入流
 * 
 * 
 * 输入流与输出流在同一个线程内，应该独立处理 彼此独立
 * 
 * @author liumy
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost", 9999);
			
			
			//控制台输入流
			BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
			// 输出流
			DataOutputStream dos = new DataOutputStream(
					client.getOutputStream());
			//输入流
			DataInputStream dis=new DataInputStream(client.getInputStream());
			while(true){
				String info=console.readLine();
				dos.writeUTF(info);
				dos.flush();
				String msg=dis.readUTF();
				System.out.println(msg);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
