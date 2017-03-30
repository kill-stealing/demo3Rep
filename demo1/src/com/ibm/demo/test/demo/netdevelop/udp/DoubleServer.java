package com.ibm.demo.test.demo.netdevelop.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * 1.创建服务端+端口
 * 2.准备接收容器
 * 3.封装成包
 * 4.接收数据
 * 5.分析数据 将字节数组转化成double类型
 * 6.释放
 * @author liumy
 *
 */
public class DoubleServer {
	public static void main(String[] args) {
		try {
			//1.创建服务端+端口
			DatagramSocket server=new DatagramSocket(8888);
			//2.准备接收容器
			byte[] container=new byte[1024];
			//3.封装成包
			DatagramPacket packer=new DatagramPacket(container, container.length);
			//4.接收数据
			server.receive(packer);
			//5.分析数据
			byte[] data=packer.getData();
			
			ByteArrayInputStream in=new ByteArrayInputStream(data);
			DataInputStream din=new DataInputStream(new BufferedInputStream(in));
			
			double a=din.readDouble();
			din.close();
			in.close();
			System.out.println(a);
			//6.释放
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
