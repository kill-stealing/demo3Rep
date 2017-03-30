package com.ibm.demo.test.demo.javascripttest;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 测试脚本引擎执行JavaScript代码
 * @author liumy
 *
 */
public class Demo01 {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		//定义变量 存储到引擎上下文
		engine.put("msg", "gaoqi is a good man");
		System.out.println(engine.get("msg"));
		String str="var user={name:'gaoqi',age:18,schools:['清华大学','北京尚学堂']};";
		str+="println(user.name+' '+msg);";
		//执行脚本
		engine.eval(str);
		engine.eval("msg='sxt is a good school';");
		System.out.println(engine.get("msg"));
		System.out.println("####################################");
		
		//定义函数
		engine.eval("function add(a,b){var sum=a+b;return sum}");
		//取得调用接口
		Invocable jsInvocable=(Invocable)engine;
		//执行js函数
		Object result1=jsInvocable.invokeFunction("add", new Object[]{12,20});
		System.out.println(result1);
		
		//导入其他java包，使用其他包中的java类 ,若需要深入了解细节，可以详细学习Rhino的语法
		String jsCode="importPackage(java.util); var list=Arrays.asList(\"北京尚学堂\",\"清华大学\",\"北京大学\");";
		engine.eval(jsCode);
		List<String> list=(List<String>)engine.get("list");
		for(String temp:list){
			System.out.println(temp);
		}
		
		//执行一个js文件（我们将a.js至于项目的src下即可）
		URL url=Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr=new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
	}
}
