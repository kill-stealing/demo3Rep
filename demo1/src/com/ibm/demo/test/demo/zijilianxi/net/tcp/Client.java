package com.ibm.demo.test.demo.zijilianxi.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			Socket client=new Socket("localhost",8888);
			DataInputStream dis=new DataInputStream(client.getInputStream());
			String echo=dis.readUTF();
			System.out.println(echo);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
