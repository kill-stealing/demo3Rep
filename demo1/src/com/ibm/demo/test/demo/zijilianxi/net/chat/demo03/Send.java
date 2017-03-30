package com.ibm.demo.test.demo.zijilianxi.net.chat.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 数据的发送 线程
 * @author liumy
 *
 */
public class Send implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private boolean isRunning=true;
	
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client){
		this();
		try {
			dos=new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			isRunning=false;
			CloseUtil.close(dos,console);
		}
	}
	
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 1.从控制台接收数据
	 * 2.发送数据
	 */
	public void send(){
		String msg=getMsgFromConsole();
		if(null!=msg&&!"".equals(msg)){
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				isRunning=false;
				CloseUtil.close(dos,console);
			}
		}
	}
	
	
	@Override
	public void run() {
		while(isRunning){
			send();
		}
	}

}
