package com.ibm.demo.test.demo.annotation.class1;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.ibm.demo.test.demo.annotation.javabean.User;

public class Demo05 {
	public void test01(Map<String, User> map,List<User> list){
		System.out.println("Demo05.test01");
	}
	public Map<String, User> test02(){
		System.out.println("Demo05.test02");
		return null;
	}
	
	public static void main(String[] args) {
		try {
			//获得指定方法参数泛型信息
			Method m=Demo05.class.getMethod("test01", Map.class,List.class);
			Type[] t=m.getGenericParameterTypes();
			for(Type paramType:t){
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType){
					Type[] genericTypes=((ParameterizedType) paramType).getActualTypeArguments();
					for(Type genericType:genericTypes){
						System.out.println("泛型类型： "+genericType);
					}
				}
			}
			
			//获得指定方法返回值泛型信息
			Method m1=Demo05.class.getMethod("test01", Map.class,List.class);
			Type t1=m1.getGenericReturnType();
			if(t1 instanceof ParameterizedType){
				Type[] types=((ParameterizedType) t1).getActualTypeArguments();
				for(Type temp:types){
					System.out.println("返回值，泛型类型 ："+temp);
				}
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
