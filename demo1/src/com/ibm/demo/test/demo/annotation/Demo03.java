package com.ibm.demo.test.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * 
 * @author liumy
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("com.ibm.demo.test.demo.annotation.SxtStudent");
			
			//获得类的所有注解
			Annotation[] anno=clazz.getDeclaredAnnotations();
			for(Annotation temp:anno){
				System.out.println(temp);
			}
			//获得类的指定的注解
			SxtTable st=(SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			//获得类的属性的注解
			Field f=clazz.getDeclaredField("studentName");
			SxtField sxtField=f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());
			
			//获得类的方法的注解
			Method method=clazz.getDeclaredMethod("getId", null);
			Annotation annome=method.getAnnotation(SxtMethod.class);
			System.out.println(annome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
