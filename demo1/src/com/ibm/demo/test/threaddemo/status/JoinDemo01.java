package com.ibm.demo.test.threaddemo.status;
/*
 * join 合并线程
 */
public class JoinDemo01 extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JoinDemo01 j1=new JoinDemo01();
		Thread t1=new Thread(j1);
		t1.start();
		
		for (int i = 0; i < 100; i++) {
			if(50==i){
				try {
					t1.join();//main 阻塞
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("main..."+i);
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("join..."+i);
		}
	}

}
