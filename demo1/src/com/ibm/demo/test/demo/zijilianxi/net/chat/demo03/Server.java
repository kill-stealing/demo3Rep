package com.ibm.demo.test.demo.zijilianxi.net.chat.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * @author liumy
 *
 */
public class Server {
	
	private List<MyChannel> all=new ArrayList<MyChannel>();
	
	/**
	 * 一个客户端 一条道路
	 * 1.输入流
	 * 2.输出流
	 * 
	 * @author liumy
	 *
	 */
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning=true;
		public MyChannel(Socket client) {
			try {
				dis=new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				CloseUtil.close(dos,dis);
				isRunning=false;
				all.remove(this);
			}
		}
		
		private String receive(){
			String msg="";
			try {
				msg=dis.readUTF();
				System.out.println("server receive "+msg);
			} catch (IOException e) {
				e.printStackTrace();
				CloseUtil.close(dis);
				isRunning=false;
				all.remove(this);
			}
			return msg;
		}
		
		private void send(String msg){
			System.out.println("server send "+msg);
			if(null==msg||"".equals(msg)){
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				CloseUtil.close(dos);
				isRunning=false;
			}
		}
		
		/**
		 * 发送给其他客户端
		 */
		private void sendOthers(){
			String msg=receive();
			for(MyChannel channel:all){
				if(channel==this){
					continue;
				}
				channel.send(msg);
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendOthers();
//				send(receive());
			}
		}
		
	}
	
	public void start() throws IOException{
		ServerSocket server=new ServerSocket(9999);
		while(true){
			Socket client=server.accept();
			MyChannel channel=new MyChannel(client);
			all.add(channel);
			new Thread(channel).start();
		}
	}

	public static void main(String[] args) throws IOException {
		new Server().start();
	}

}
