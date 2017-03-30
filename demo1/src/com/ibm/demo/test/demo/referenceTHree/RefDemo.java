package com.ibm.demo.test.demo.referenceTHree;

import java.lang.ref.WeakReference;

/*
 * 引用分类：强 软 弱 虚
 * 强与弱引用
 */
public class RefDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testStong();
	}
	
	public static void testStong(){
		//字符串常量池 共享 不能回收
//		String str="bjsxt is very good";//不能回收
		String str=new String("bjsxt is very good");//被回收
		//弱引用 管理对象
		WeakReference<String> wr=new WeakReference<String>(str);
		System.out.println("gc 运行前"+wr.get());
		//断开引用
		str=null;
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc 运行后"+wr.get() );
	}

}
