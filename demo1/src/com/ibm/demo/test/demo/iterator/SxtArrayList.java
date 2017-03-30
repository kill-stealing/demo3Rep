package com.ibm.demo.test.demo.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标：使用泛型可以操作多个类型
 * 
 * 
 * @author bj
 *
 */
public class SxtArrayList<E> implements java.lang.Iterable<E>{
	//数组
	private Object[] elem=new Object[5];
	//ʵ�ʴ�С
	private int size =0;
	
	
	public int size(){
		return this.size;
	}
	
	/**
	 * ��ĩβ���Ԫ��
	 * @param ele
	 */
	public void add(E ele){
		if(this.size==elem.length){ //�������� -->����
			elem=Arrays.copyOf(elem, elem.length+5);			
		}
		
		elem[size] =ele; //�����м���Ԫ�� ���
		size++; //ʵ�ʴ�С+1		
	}	
	
	public Iterator<E> iterator(){
		return new Iterator<E>(){ //����Iterator������ӿ� ʵ����(û�����)�Ķ���
			//������ -->ָ��  �α�
			private int coursor=-1;
			//�ж��Ƿ������һ��
			public boolean hasNext(){
				return coursor+1<size;
			}
			//��ȡ��һ��
			public E next(){
				coursor++;
				return (E)elem[coursor];
			}
			//ɾ����һ��
			public void remove(){
				//�ƶ�����Ԫ��
				System.arraycopy(elem, 
						coursor+1, elem, coursor,
						size-(coursor+1));
				//ʵ�ʴ�С-1
				size--;
				//����
				this.coursor--;
			}
			
		};
	}
	public static void main(String[] args) {
		SxtArrayList<Integer> list =new SxtArrayList<Integer>();
		list.add(1);//int -->Integer
		list.add(2);
		for(Integer e:list){
			System.out.println(e);
		}
		
		System.out.println("----------------");
		SxtArrayList<String> list2 =new SxtArrayList<String>();
		list2.add("����");
		list2.add("�?��");
		list2.add("��ʿ��");
		list2.add("������");
		
		Iterator<String> it =list2.iterator();
		while(it.hasNext()){
			String e =it.next();
			System.out.println(e);
		}
	}

}
