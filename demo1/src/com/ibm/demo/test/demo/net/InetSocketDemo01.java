package com.ibm.demo.test.demo.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 封装端口：在InetAddress基础上+端口
 * @author liumy
 *
 */
public class InetSocketDemo01 {

	public static void main(String[] args) {
		InetSocketAddress address=new InetSocketAddress("127.0.0.1",9999);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		InetAddress add=address.getAddress();
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
	}

}
