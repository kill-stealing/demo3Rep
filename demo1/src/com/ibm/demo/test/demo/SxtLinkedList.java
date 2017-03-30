package com.ibm.demo.test.demo;

public class SxtLinkedList {
	
	private Node first;
	private Node last;
	private int size;
	
	public void add(Object obj){
		Node n=new Node();
		if(first==null){
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			first=n;
			last=n;
		}else{
			//直接往last节点后增加
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last=n;
		}
		size++;
	}
	
	public Object get(int index){ //2
		
		//index 越界
		if(index<0||index>=size){
			try {
				throw new Exception("dd");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//0 1 2 3 4
		Node temp=null;
		if(first==null){
			
		}else{
			temp=first;
			for (int i = 0; i < index; i++) {
				temp=temp.next;
			}
		}
		return temp.obj;
	}
	
	public int size(){
		return size;
	}
	
	public void remove(int index){
		//index 越界
		if(index<0||index>=size){
			try {
				throw new Exception("dd");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		Node temp=null;
		if(first==null){
			
		}else{
			temp=first;
			for (int i = 0; i < index; i++) {
				temp=temp.next;
			}
		}
		if (temp!=null) {
			Node up=temp.previous;
			Node down=temp.previous;
			up.next=down;
			down.previous=up;
		}
		size--;
	}
	
	public Node node(int index){
		Node temp=null;
		if(first!=null){
			if(index<(size>>1)){
				temp=first;
				for (int i = 0; i < index; i++) {
					temp=temp.next;
				}
			}else{
				temp=last;
				for (int i = size-1; i > index; i--) {
					temp=temp.previous;
				}
			}
			
		}
		return temp;
	}
	
	public void add(int index,Object obj){
		Node temp=node(index);
		Node newNode=new Node();
		newNode.obj=obj;
		if(temp!=null){
			Node upNode=temp.previous;
			Node downNode=temp.next;
			upNode.next=newNode;
			newNode.previous=upNode;
			downNode.previous=newNode;
			newNode.next=downNode;
			size++;
		}
	}
	
	
	
	public static void main(String[] args) {
		
		SxtLinkedList list=new SxtLinkedList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
	}
}
