package com.ibm.demo.test.demo.annotation.class1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.ibm.demo.test.demo.annotation.javabean.User;

/**
 * 通过反射api动态操作：构造器，方法，属性
 * @author liumy
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path = "com.ibm.demo.test.demo.annotation.javabean.User";
		try {
			Class<User> claz = (Class<User>) Class.forName(path);
			//通过反射API动态调用构造方法，构造对象
			User u=(User)claz.newInstance();//其实是调用了User的无参构造方法
			System.out.println(u);
			Constructor<User> c1=claz.getDeclaredConstructor(String.class,int.class,int.class);
			User u2=c1.newInstance("高琪二",1001,18);
			System.out.println("fdsaf "+u2.getuName());
			
			
			//通过反射API调用普通方法
			User u3=claz.newInstance();
//			u3.getuName();
			Method method=claz.getDeclaredMethod("setuName", String.class);
			method.invoke(u3, "高企三"); //u3.setuName("高企三");
			System.out.println(u3.getuName());
			
			//通过反射API操作属性
			User u4=claz.newInstance();
			Field field=claz.getDeclaredField("uName");
			field.setAccessible(true);//这个属性表示不需要做安全检查了，可以直接访问
			field.set(u4, "高气死"); //通过反射直接写属性
			System.out.println(u4.getuName());
			System.out.println(field.get(u4));//通过反射直接读属性的值
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
