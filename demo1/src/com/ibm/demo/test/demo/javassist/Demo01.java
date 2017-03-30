package com.ibm.demo.test.demo.javassist;

import java.io.IOException;
import java.lang.reflect.Constructor;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 测试使用javassist
 * 
 * @author liumy
 *
 */
public class Demo01 {
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("com.ibm.demo.test.demo.javassist.Emp");

		// 创建属性
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);

		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod m2 = CtMethod.make(
				"public void setEmpno(int empno){this.empno=empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);

		// 添加构造器
		CtConstructor constructor = new CtConstructor(new CtClass[] {
				CtClass.intType, pool.get("java.lang.String") }, cc);
		constructor.setBody("{this.empno=empno;this.ename=ename;}");
		cc.addConstructor(constructor);
		cc.writeFile("C:/MyJava");//将上面构造好的类写入到C:/myjava中
		System.out.println("生成类，成功");
		
	}
}
