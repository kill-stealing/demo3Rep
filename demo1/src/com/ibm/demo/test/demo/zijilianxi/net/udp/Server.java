package com.ibm.demo.test.demo.zijilianxi.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

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
			ByteArrayInputStream bis=new ByteArrayInputStream(data);
			DataInputStream dis=new DataInputStream(bis);
			double num=dis.readDouble();
			System.out.println(num);
			System.out.println(new String(data,0,data.length));
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
