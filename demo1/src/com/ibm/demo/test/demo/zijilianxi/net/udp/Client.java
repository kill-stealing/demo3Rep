package com.ibm.demo.test.demo.zijilianxi.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {

	public static void main(String[] args) {
		try {
			//创建客服端
			DatagramSocket client=new DatagramSocket(6666);
			//准备数据
			double num=89.12;
			byte[] data=convert(num);
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
	
	/**
	 * 字节数组 数据源+data输出流
	 * @param num
	 * @return
	 */
	public static byte[] convert(double num){
		byte[] data=null;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(bos);
		try {
			dos.writeDouble(num);
			dos.flush();
			data=bos.toByteArray();
			dos.close();
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

}
