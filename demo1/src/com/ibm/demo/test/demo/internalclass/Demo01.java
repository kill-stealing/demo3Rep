package com.ibm.demo.test.demo.internalclass;

/**
 * 测试内部类
 * @author liumy
 *
 */
public class Demo01 {
	//静态内部类
	private static class StaticNestedClass{
		
	}
	//普通内部类(成员内部类)
	private class FieldInnerClass{
		
	}
	
	void sayHello(){
		//方法内部类
		class LocalClass{
			
		}
		//匿名内部类
		Runnable runnable=new Runnable() {//两个作用：定义了匿名内部类的类体；创建了匿名内部类的一个实例
			@Override
			public void run() {
				
			}
		};
	}
	
}
