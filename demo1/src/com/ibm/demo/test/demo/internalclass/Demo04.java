package com.ibm.demo.test.demo.internalclass;

/**
 * 测试方法内部类（局部内部类）
 * @author liumy
 *
 */
public class Demo04 {
	
}

class Outer04{
	public void test(){
		/*final*/ int a=3;
		
		class Inner{
			int b=10;
			
			/*static*/ int c=3; //方法内部类中只能定义非静态成员
			
			void tt(){
				System.out.println(b);
//				System.out.println(a);
				//方法内部类中不能引用所在方法的普通局部变量，除非是常量，原因如下：
				//方法的生命周期和方法内部类的生命周期不一致。方法执行完，内部类对象可能仍然存在。
				
			}
		}
	}
}
