package com.ibm.demo.test;

public class TestInterface1 implements TestInterface{
	
	public final int[] aaa1=new int[4];
	
	int a=111;
	
	public static void main(String[] args) {
		/*TestInterface t=new TestInterface1();
		System.out.println(TestInterface.a);
		String aaa=new String("dddd");
		System.out.println(aaa);*/
		
		/*String str3="def";
		String str4="def";
		System.out.println(str3.indexOf('y'));
		String s=str3.substring(0);
		System.out.println(s);
		TestInterface1 te1=new TestInterface1();
		te1.aaa1[0]=1;
		te1.aaa1[1]=2;*/
		
		/*String s1="abc";
		s1="aaa";
		
		s1=new String("ddd");
		System.out.println(s1);
		String s2="abc";
		
		TestInterface1 t=new TestInterface1();
		t.change(s2);
		System.out.println(s2);
		String s3="abc";
		s3=t.change1(s3);
		System.out.println(s3);*/
		
		int[][] a={
					{4,6},
					{5,1}
				  };
		int[][] b={
				{1,3},
				{6,9}
			  };
		int[][] c=new int[2][2];
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				c[i][j]=a[i][j]+b[i][j];
			}
		}
		System.out.println(c);
		
	}
	
	public void change(String str){
		str="bbb";
	}
	
	public String change1(String str){
		str="ccc";
		return str;
	}
}
