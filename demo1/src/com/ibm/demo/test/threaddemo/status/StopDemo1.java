package com.ibm.demo.test.threaddemo.status;

public class StopDemo1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Study s=new Study();
		new Thread(s).start();
		for (int i = 0; i < 1000; i++) {
			if(50==i){
				s.stop();
			}
			System.out.println("main ..."+i);
		}
	}

}
class Study implements Runnable{
	//1.线程类中定义线程体使用的标识
	private boolean flag=true;
	
	@Override
	public void run() {
		//2.线程体使用该标识
		while(flag){
			System.out.println("study thread ....");
		}
	}
	
	//3.定义改变标识的方法
	public void stop(){
		this.flag=false;
	}
	
}