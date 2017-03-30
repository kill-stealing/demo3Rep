package com.ibm.demo.test.demo.classloadprocess1;

/**
 * 测试简单的加密解密（取反）操作
 * @author liumy
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		try {
			int a=3;
			System.out.println(Integer.toBinaryString(a^0xff));
//			加密后的class文件，正常的类加载器无法加载，报classFormatError
//			FileSystemClassLoader f=new FileSystemClassLoader("C:/myJava/temp");
//			Class<?> c=f.loadClass("HelloWorld");
			
			DecrptClassLoader f=new DecrptClassLoader("C:/myJava/temp");
			Class<?> c=f.loadClass("HelloWorld");
			System.out.println(c);
			Object b=c.newInstance();
			System.out.println(c.getMethod("toString", null).invoke(b, null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
