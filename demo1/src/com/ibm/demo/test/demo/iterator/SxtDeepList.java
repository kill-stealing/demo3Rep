package com.ibm.demo.test.demo.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标：深入
 * 途锟斤拷: 使锟斤拷锟斤拷 锟节诧拷锟斤拷  |锟斤拷锟斤拷锟节诧拷锟斤拷
 * 
 * 深入
 * 1、使用内部类，实现迭代器
 * 2锟斤拷使锟斤拷Iterable 实锟斤拷foreach锟斤拷锟�
 * 3锟斤拷锟斤拷锟斤拷末尾锟斤拷锟皆拷氐姆锟斤拷锟�
 * 
 * @author bj
 *
 */
public class SxtDeepList implements java.lang.Iterable{
	//锟斤拷锟斤拷 锟芥储值
	private String[] elem=new String[5];
	//实锟绞达拷小
	private int size =0;
	
	
	public int size(){
		return this.size;
	}
	
	/**
	 * 锟斤拷末尾锟斤拷锟皆拷锟�
	 * @param ele
	 */
	public void add(String ele){
		if(this.size==elem.length){ //锟斤拷锟斤拷锟斤拷锟斤拷 -->锟斤拷锟斤拷
			elem=Arrays.copyOf(elem, elem.length+5);			
		}
		
		elem[size] =ele; //锟斤拷锟斤拷锟叫硷拷锟斤拷元锟斤拷 锟斤拷锟�
		size++; //实锟绞达拷小+1		
	}
	
	//锟节诧拷锟斤拷
	private class MyIter implements Iterator {
		//锟斤拷锟斤拷锟斤拷 -->指锟斤拷  锟轿憋拷
		private int coursor=-1;
		//锟叫讹拷锟角凤拷锟斤拷锟斤拷锟揭伙拷锟�
		public boolean hasNext(){
			return coursor+1<size;
		}
		//锟斤拷取锟斤拷一锟斤拷
		public String next(){
			coursor++;
			return elem[coursor];
		}
		//删锟斤拷锟斤拷一锟斤拷
		public void remove(){
			//锟狡讹拷锟斤拷锟斤拷元锟斤拷
			System.arraycopy(elem, 
					coursor+1, elem, coursor,
					/*SxtDeepList.this.*/size-(coursor+1));
			//实锟绞达拷小-1
			/*SxtDeepList.this.*/size--;
			//锟斤拷锟斤拷
			this.coursor--;
		}
	
	}
	
	public Iterator iterator1(){
		return new MyIter();
	}
	
	public Iterator iterator2(){
		class MyIter implements Iterator {
			//锟斤拷锟斤拷锟斤拷 -->指锟斤拷  锟轿憋拷
			private int coursor=-1;
			//锟叫讹拷锟角凤拷锟斤拷锟斤拷锟揭伙拷锟�
			public boolean hasNext(){
				return coursor+1<size;
			}
			//锟斤拷取锟斤拷一锟斤拷
			public String next(){
				coursor++;
				return elem[coursor];
			}
			//删锟斤拷锟斤拷一锟斤拷
			public void remove(){
				//锟狡讹拷锟斤拷锟斤拷元锟斤拷
				System.arraycopy(elem, 
						coursor+1, elem, coursor,
						/*SxtDeepList.this.*/size-(coursor+1));
				//实锟绞达拷小-1
				/*SxtDeepList.this.*/size--;
				//锟斤拷锟斤拷
				this.coursor--;
			}
		
		}
		return new MyIter();
	}
	
	
	public Iterator iterator(){
		return new Iterator(){ //锟斤拷锟斤拷Iterator锟斤拷锟斤拷锟斤拷涌锟�实锟斤拷锟斤拷(没锟斤拷锟斤拷锟�锟侥讹拷锟斤拷
			//锟斤拷锟斤拷锟斤拷 -->指锟斤拷  锟轿憋拷
			private int coursor=-1;
			//锟叫讹拷锟角凤拷锟斤拷锟斤拷锟揭伙拷锟�
			public boolean hasNext(){
				return coursor+1<size;
			}
			//锟斤拷取锟斤拷一锟斤拷
			public String next(){
				coursor++;
				return elem[coursor];
			}
			//删锟斤拷锟斤拷一锟斤拷
			public void remove(){
				//锟狡讹拷锟斤拷锟斤拷元锟斤拷
				System.arraycopy(elem, 
						coursor+1, elem, coursor,
						size-(coursor+1));
				//实锟绞达拷小-1
				size--;
				//锟斤拷锟斤拷
				this.coursor--;
			}
			
		};
	}
	public static void main(String[] args) {
		SxtDeepList list =new SxtDeepList();
		list.add("a");
		list.add("b");
		list.add("c1");
		list.add("c2");
		list.add("c3");
		list.add("c4");
		list.add("c5");
		Iterator it =list.iterator();
		while(it.hasNext()){ //锟斤拷锟叫讹拷 锟斤拷锟饺�
			System.out.println(it.next());
			//it.remove();
		}
		System.out.println(list.size());
		for(Object str:list){
			System.out.println(str);
		}
		
		
		ArrayList list2 =new ArrayList();
		list2.add("a");
		list2.add("a");
		list2.add("a");
		for(Object obj:list2){ //foreach
			System.out.println(obj);
		}
	}

}
