package com.ibm.demo.test.demo.zijilianxi.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class MyClient {

	public static void main(String[] args) {
		try {
			//创建客服端
			DatagramSocket client=new DatagramSocket(6666);
			//准备数据
			String msg="udp编程";
			byte[] data=msg.getBytes();
			//打包 (发送的地点及端口)
			DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
			//4.发送
			client.send(packet);
			//5.释放
			client.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
