package com.ibm.demo.test.demo.annotation;

@SxtAnnotation01(age=19,studentName="老高",
id=1001,schools={"北京尚学堂","北京航空大學"})
public class Demo02 {
	@SxtAnnotation01
	public void test(){
		
	}
	
	@SxtAnnotation02("aaa")
	public void test1(){
		
	}
	
	@SxtAnnotation02(value="aaa")
	public void test2(){
		
	}
}
