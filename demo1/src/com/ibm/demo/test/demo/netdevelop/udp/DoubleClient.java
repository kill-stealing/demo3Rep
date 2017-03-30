package com.ibm.demo.test.demo.netdevelop.udp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端
 * 1.创建客户端+端口
 * 2.准备数据
 * 3.打包（发送的地点及端口）
 * @author liumy
 *
 */
public class DoubleClient {
	public static void main(String[] args) {
		try {
			//1.创建客户端+端口
			DatagramSocket client=new DatagramSocket(6666);
			//2.准备数据
			double msg=80.11;
			ByteArrayOutputStream bin=new ByteArrayOutputStream();
			DataOutputStream os=new DataOutputStream(new BufferedOutputStream(bin));
			os.writeDouble(msg);
			os.flush();
			
			byte[] data=bin.toByteArray();
			os.close();
			bin.close();
			//3.打包（发送的地点及端口）
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
