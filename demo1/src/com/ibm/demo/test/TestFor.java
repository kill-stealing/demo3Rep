package com.ibm.demo.test;

public class TestFor {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int a=0;
		/*for(int i=0;i<1000;i++){
			if(i%5==0){
				a++;
				if(a%3==0&&a!=0){
					System.out.println(i+" ");
				}else{
					System.out.print(i+" ");
				}
				
			}
		}*/
		
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(i*j)+"  ");
			}
			System.out.println();
		}
		
	}

}
