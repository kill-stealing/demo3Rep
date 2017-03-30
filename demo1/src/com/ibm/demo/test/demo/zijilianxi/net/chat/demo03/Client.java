package com.ibm.demo.test.demo.zijilianxi.net.chat.demo03;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端
 * 写出数据  输出流
 * 读取数据 输入流
 * 
 * 
 * 输入流与输出流在同一个线程内，应该独立处理，彼此独立
 * @author liumy
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost",9999);
		//控制台输入流
		new Thread(new Send(client)).start();
		new Thread(new Receive(client)).start();
		
	}
}
