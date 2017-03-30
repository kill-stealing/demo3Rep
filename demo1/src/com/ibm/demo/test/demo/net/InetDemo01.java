package com.ibm.demo.test.demo.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 没有封装端口
 * @author liumy
 *
 */
public class InetDemo01 {

	public static void main(String[] args) {
		try {
			InetAddress addr=InetAddress.getLocalHost();
			System.out.println(addr.getHostAddress());
			System.out.println(addr.getHostName());
			addr=InetAddress.getByName("www.baidu.com");
			System.out.println(addr.getHostAddress());
			System.out.println(addr.getHostName());
			addr=InetAddress.getByName("61.135.169.125");
			System.out.println(addr.getHostAddress());
			System.out.println(addr.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
