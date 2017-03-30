package com.ibm.demo.test.demo.iterator;
/**
 * Ŀ��:���������ԭ��
 * �����: ����ʹ��
 * 
 * @author bj
 *
 */
public class SxtSimpleList {
	//���� �洢ֵ
	private String[] elem={"a","b","c"};
	//��С
	private int size =elem.length;
	
	
	public int size(){
		return this.size;
	}
	
	//������ -->ָ��  �α�
	private int coursor=-1;
	//�ж��Ƿ������һ��
	public boolean hasNext(){
		return coursor+1<size;
	}
	//��ȡ��һ��
	public String next(){
		coursor++;
		return elem[coursor];
	}
	//ɾ����һ��
	public void remove(){
		//�ƶ�����Ԫ��
		System.arraycopy(elem, 
				coursor+1, elem, coursor,
				this.size-(coursor+1));
		//ʵ�ʴ�С-1
		this.size--;
		//����
		this.coursor--;
	}
	
	
	
	

	public static void main(String[] args) {
		SxtSimpleList list =new SxtSimpleList();
		if(list.hasNext()){			
			System.out.println(list.next());
			list.remove();
		}
		if(list.hasNext()){
			System.out.println(list.next());
			list.remove();
		}
		if(list.hasNext()){
			System.out.println(list.next());
			list.remove();
		}
		//���жϺ��ȡ
		if(list.hasNext()){ //�����ȡֵ  
			System.out.println(list.next());
			list.remove();
		}
		System.out.println(list.size());
				
		list =new SxtSimpleList();
		while(list.hasNext()){
			System.out.println(list.next());
		}
		
	}

}
