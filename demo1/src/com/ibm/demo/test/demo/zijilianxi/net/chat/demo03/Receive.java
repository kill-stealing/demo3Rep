package com.ibm.demo.test.demo.zijilianxi.net.chat.demo03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收数据
 * @author liumy
 *
 */
public class Receive implements Runnable{
	private DataInputStream dis;
	private boolean isRunning=true;
	
	public Receive() {
		
	}
	
	public Receive(Socket client) {
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning=false;
			CloseUtil.close(dis);
		}
	}
	
	public String receive(){
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			isRunning=false;
			CloseUtil.close(dis);
		}
		return msg;
	}
	
	@Override
	public void run() {
		while(isRunning){
			System.out.println("Receive "+receive());
		}
	}

}
