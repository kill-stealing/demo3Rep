package com.ibm.demo.test.demo.annotation.class1;

/**
 * 测试各种类型(class，interface，enum，annotation，primitive type，void)java。lang。class对象的获取方式
 * @author liumy
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path="com.ibm.demo.test.demo.annotation.javabean.User";
		
		try {
			Class<?> claz=Class.forName(path);
			
			System.out.println(claz.hashCode());
			
			Class<?> claz2=Class.forName(path);//一个类
			System.out.println(claz2.hashCode());
			
			Class clz=String.class;
			Class clz1=path.getClass();
			System.out.println(clz==clz1);
			
			Class intClaz=int.class;
			System.out.println(intClaz);
			
			//这个hashcode跟数组的大小没关系，跟几维数组和类型有关系
			int[] arr01=new int[10];
			int[] arr02=new int[30];
			int[][] arr03=new int[2][];
			double[] arr04=new double[3];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
