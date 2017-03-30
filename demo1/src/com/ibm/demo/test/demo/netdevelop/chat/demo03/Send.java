package com.ibm.demo.test.demo.netdevelop.chat.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据 线程
 * @author liumy
 *
 */
public class Send implements Runnable{
	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	//控制线程
	private boolean isRunning=true;
	
	public Send(){
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client){
		this();
		try {
			dos=new DataOutputStream(
					client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		try {
			if(null!=msg&&!"".equals(msg)){
				dos.writeUTF(msg);
				dos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			send();
		}
	}
	
}
