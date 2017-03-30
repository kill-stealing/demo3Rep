package com.ibm.demo.test.demo.netdevelop.chat.demo04;

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
	
	public static void main(String[] args) {
		new Server().start();
	}
	
	public void start(){
		try {
			ServerSocket server=new ServerSocket(9999);
			while(true){
				Socket client=server.accept();
				MyChannel channel=new MyChannel(client);
				all.add(channel);
				new Thread(channel).start();//一条道路
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 一个客户端 一条道路
	 * 1.输入流
	 * 2.输出流
	 * 3.接收数据
	 * 4。发送数据
	 * @author liumy
	 *
	 */
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning=true;
		private String name;
		
		public MyChannel(Socket client) {
			try {
				dis=new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name=dis.readUTF();
				System.out.println(this.name);
				this.send("欢迎进入聊天室");
				this.sendOthers(this.name+"进入了聊天室");
				
			} catch (IOException e) {
				isRunning=false;
				CloseUtil.closeAll(dos,dis);
				all.remove(this);// 移除自身
			}
		}
		
		private String receive(){
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				isRunning=false;
				CloseUtil.closeAll(dis);
				all.remove(this);// 移除自身
			}
			return msg;
		}
		
		private void send(String msg){
			if(null==msg||msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning=false;
				CloseUtil.closeAll(dos);
				all.remove(this);// 移除自身
			}
			
		}
		
		/**
		 * 发送给其他客户端
		 */
		private void sendOthers(String msg){
			//是否为私聊
			if(msg.startsWith("@")){
				//私聊
				msg.substring(0);
				String name=msg.substring(1,msg.indexOf(":"));
				String content=msg.substring(msg.indexOf(":")+1);
				//遍历容器
				for(MyChannel other:all){
					if(name.equals(other.name)){
						other.send(this.name+"对你说："+content);
						continue;
					}
				}
			}else{
				
				//遍历容器
				for(MyChannel other:all){
					if(other==this){
						continue;
					}
					if(msg.indexOf("进入了")!=-1){
						other.send(msg);
						continue;
					}else{
						other.send(this.name+"对所有人说："+msg);
						continue;
					}
					
				}
			}
			
			
			
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendOthers(this.receive());
			}
			
		}
		
	}
}
