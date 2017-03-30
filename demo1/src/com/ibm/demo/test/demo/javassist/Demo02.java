package com.ibm.demo.test.demo.javassist;

import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;

/**
 * 测试javassist 的API
 * @author liumy
 *
 */
public class Demo02 {
	public static void main(String[] args) throws Exception {
//		test01();
//		test02();
//		test03();
//		test04();
		test05();
	}
	
	/**
	 * 处理类的基本用法
	 * @throws Exception 
	 */
	public static void test01() throws Exception{
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("com.ibm.demo.test.demo.javassist.Emp");
		byte[] bytes=cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		
		
		System.out.println(cc.getName());//获取类名
		System.out.println(cc.getSimpleName());//获取简要类名
		
		System.out.println(cc.getSuperclass());//获得父类
		System.out.println(cc.getInterfaces());//获得接口
	}
	
	/**
	 * 测试产生新的方法
	 */
	public static void test02() throws Exception{
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("com.ibm.demo.test.demo.javassist.Emp");
		
//		CtMethod m=CtMethod.make("public int add(int a,int b){return a+b;}", cc);
//		CtMethod m1=new CtMethod(CtClass.intType, "add", CtClass[]{CtClass.intType,CtClass.intType}, cc);
		CtMethod m=new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType,CtClass.intType}, cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"www.sxt.cn\");return $1+$2;}");
		cc.addMethod(m);
		
		//通过反射调用新生成的方法
		Class clazz=cc.toClass();
		Object obj=clazz.newInstance();//通过调用Emp的无参构造器，创建新的Emp对象
		Method method=clazz.getDeclaredMethod("add", int.class,int.class);
		Object result=method.invoke(obj, 200,300);
		System.out.println(result);
	}
	
	/**
	 * 修改已有的方法的信息,修改方法体的内容
	 * @throws Exception
	 */
	public static void test03() throws Exception{
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("com.ibm.demo.test.demo.javassist.Emp");
		CtMethod cm=cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
		cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
		cm.insertAt(30, "System.out.println(\"test\");");
		cm.insertAfter("System.out.println(\"end!!!\");");
		Class clazz=cc.toClass();
		Object obj=clazz.newInstance();
		Method m=clazz.getDeclaredMethod("sayHello", int.class);
		m.invoke(obj, 200);
	}
	
	/**
	 * 修改类的属性
	 */
	public static void test04() throws Exception{
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("com.ibm.demo.test.demo.javassist.Emp");
//		CtField f1 = CtField.make("private int empno;", cc);
		CtField f1=new CtField(CtClass.intType, "salary", cc);
		f1.setModifiers(Modifier.PRIVATE);
//		cc.getDeclaredField("ename");//获取指定的属性
		CtMethod m1=CtNewMethod.getter("getSalary", f1);
		CtMethod m2=CtNewMethod.setter("setSalary", f1);
		cc.addMethod(m1);
		cc.addMethod(m2);
		cc.addField(f1);
		
		Class clazz=cc.toClass();
		Object obj=clazz.newInstance();
		Method method=clazz.getDeclaredMethod("setSalary", int.class);
		Object result=method.invoke(obj, 100);
		Method method1=clazz.getDeclaredMethod("getSalary");
		Object result1=method1.invoke(obj);
		System.out.println(result);
		System.out.println(result1);
	}
	
	/**
	 * 获得构造器方法 及其操作
	 */
	public static void test05() throws Exception{
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("com.ibm.demo.test.demo.javassist.Emp");
		CtConstructor[] constructors=cc.getConstructors();
		for(CtConstructor c:constructors){
			System.out.println(c);
		}
	}
}
