package com.ibm.demo.test.demo.zijilianxi.net.chat.demo04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端 写出数据 输出流 读取数据 输入流
 * 
 * 
 * 加入名称
 * 
 * 输入流与输出流在同一个线程内，应该独立处理，彼此独立
 * 
 * @author liumy
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		System.out.println("请输入名称：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		if("".equals(name)){
			return;
		}
		Socket client = new Socket("localhost", 9999);
		// 控制台输入流
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();

	}
}
