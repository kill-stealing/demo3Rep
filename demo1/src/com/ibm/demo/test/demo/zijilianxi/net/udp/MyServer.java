package com.ibm.demo.test.demo.zijilianxi.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer {

	public static void main(String[] args) {
		try {
			//1、创建服务端
			DatagramSocket server=new DatagramSocket(8888);
			//2、准备接收容器 字节数组 封装socketPacket
			byte[] container=new byte[1024];
			//3、封装成包
			DatagramPacket packet=new DatagramPacket(container, container.length);
			//4、接收数据
			server.receive(packet);
			//5、分析数据
			byte[] data=packet.getData();
			int len =packet.getLength();
			System.out.println(new String(data,0,len));
			//6、释放
			server.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
