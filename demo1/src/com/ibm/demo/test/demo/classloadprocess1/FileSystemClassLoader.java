package com.ibm.demo.test.demo.classloadprocess1;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 自定义文件类加载器
 * 
 * @author liumy
 *
 */
public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);

		// 应该先查询有没有加载这个类，如果已经加载，则直接返回，如果没有，则加载新的类
		if (c != null) {
			return c;
		} else {
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (c != null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if (classData == null) {
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
					return c;
				}
			}
		}
	}
	
	private byte[] getClassData(String name){
		String path=rootDir+"/"+name.replace(".", "/")+".class";
		byte[] data=new byte[1024];
		BufferedInputStream bis=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			bis=new BufferedInputStream(new FileInputStream(new File(path)));
			int len=0;
			while(-1!=(len=bis.read(data))){
				baos.write(data, 0, len);
			}
			baos.flush();
			data=baos.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		String name="com.ibm.test.HelloWorld";
		FileSystemClassLoader f=new FileSystemClassLoader("C:/myJava");
		FileSystemClassLoader f2=new FileSystemClassLoader("C:/myJava");
		Class<?> c=f.loadClass(name);
		Class<?> c2=f.loadClass(name);
		Class<?> c3=f2.loadClass(name);
		
		Class<?> c4=f2.loadClass("java.lang.String");
		Class<?> c5=f2.loadClass("com.ibm.demo.test.demo.classloadprocess1.Demo02");
		
		Object b=c.newInstance();
		System.out.println(c.getMethod("toString", null).invoke(b, null));
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		
		System.out.println(c.getClassLoader());
		System.out.println(c2.getClassLoader());
		System.out.println(c3.getClassLoader());
		System.out.println(c4.getClassLoader());
		System.out.println(c5.getClassLoader());
	}
}
