package com.ibm.demo.test.demo.dynamiccompiler;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class Demo01 {
	public static void main(String[] args) throws IOException {
		
		String str2="Hello520207700010407585.java";
		String[] str1=str2.split("\\.");
		
		//通过IO流 操作，将字符串存储成一个临时文件，然后调用动态编译方法
		String path="C:/myJava/";
		File f=java.io.File.createTempFile("Hello", ".java",new File(path));
		OutputStream os=new BufferedOutputStream(new FileOutputStream(f));
		String fileName=f.getName();
		String[] className=fileName.split("\\.");
		String str="public class "+className[0]+"{public static void main(String[] args){System.out.println(\"haha\");}}";
		os.write(str.getBytes());
		os.flush();
		os.close();
        
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int result=compiler.run(null, null, null, path+fileName);
//		int result=compiler.run(null, null, null, "C:/myJava/HelloWorld.java");
		System.out.println(result==0?"成功":"失败");
		
		 //在程序退出时删除临时文件
        f.deleteOnExit();
        
//        Runtime run=Runtime.getRuntime();
//        Process process=run.exec("java -cp C:/myJava "+className[0]);
//        BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream()));
//        int len=0;
//        char[] data=new char[1024];
//        while(-1!=(len=br.read(data))){
//        	System.out.println(new String(data,0,len));
//        }
//        br.close();
        
        //通过反射运行编译好的类
        URL[] urls=new URL[]{new URL("file:/"+"C:/myJava/")};
        URLClassLoader loader=new URLClassLoader(urls);
        try {
			Class c=loader.loadClass(className[0]);
			Method m=c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[]{"aa","bb"});
			//由于可变参数是JDK1.5之后才有，上面的代码会编译成：m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题；
			//因此，必须要加上(Object)转型，避免这个问题。
			//public static void mmm(String[] a,String[] b)
			//public static void main(String[] args)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
