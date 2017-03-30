package com.ibm.demo.test.demo.designpattern.state;

public class Client {
	public static void main(String[] args) {
		Context con=new Context();
		con.setState(new FreeState());
		con.setState(new BookedState());
	}
}
