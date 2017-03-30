package com.ibm.demo.test.threaddemo.sync;
/**
 * 单例设计模式：确保一个类只有一个对象
 * @author liumy
 *
 */
public class SynDemo02 {

	public static void main(String[] args) {
		/*Jvm j1=Jvm.getInstance(500);
		Jvm j2=Jvm.getInstance(2000);
		Thread t1=new Thread(j1);
		Thread t2=new Thread(j2);
		t1.start();
		t2.start();
		System.out.println(j1);
		System.out.println(j2);
		System.out.println(j1==j2);*/
		JvmThread t1=new JvmThread(100);
		JvmThread t2=new JvmThread(500);
		t1.start();
		t2.start();
	}

}

class JvmThread extends Thread{
	private long time;
	public JvmThread() {
		
	}
	
	public JvmThread(long time) {
		this.time=time;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->创建"+Jvm.getInstance2(time));
	}
}

/**
 * 确保一个类只有一个对象
 * 懒汉式 double checking
 * 1.构造器私有化,避免外部直接创建对象
 * 2.声明一个私有的静态变量
 * 3.创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
 * @author liumy
 *
 */
class Jvm extends Thread{
	 //* * 2.声明一个私有的静态变量
	private static Jvm instance=null;
	
	//构造器私有化,避免外部直接创建对象
	private Jvm(){
		
	}
	
	//创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
	public static  Jvm getInstance3(long time){
		//提高已经存在对象的访问效率
		if(null==instance){
			synchronized(Jvm.class){
				if(null==instance){
					try {
						Thread.sleep(time);//
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance=new Jvm();
				}
			}
		}
		return instance;
	}
	
	//创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
	public static  Jvm getInstance2(long time){
		//效率不高 存在对象也需要等待
		synchronized(Jvm.class){ 
			if(null==instance){
				try {
					Thread.sleep(time);//
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance=new Jvm();
			}
			return instance;
		}
	}
	
	
	//创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
	public static synchronized Jvm getInstance(long time){
		if(null==instance){
			try {
				Thread.sleep(time);//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance=new Jvm();
		}
		return instance;
	}
	
	//创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
	public static Jvm getInstance1(long time){
		if(null==instance){
			try {
				Thread.sleep(time);//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance=new Jvm();
		}
		return instance;
	}
}