package com.ibm.demo.test.demo.netdevelop.chat.demo02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收数据
 * @author liumy
 *
 */
public class Receive implements Runnable{
	//输入流
	private DataInputStream dis;
	//线程标识
	private boolean isRunning=true;
	public Receive() {
		
	}
	
	public Receive(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
	}
	
	/**
	 * 接收数据
	 * @return
	 */
	public String receive(){
		try {
			return dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dis);
		}
		return "";
	}

	@Override
	public void run() {
		while(isRunning){
			System.out.println(receive());
		}
	}

}
